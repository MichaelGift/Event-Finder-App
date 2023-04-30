package com.myth.ticketmasterapp.presentation.fragments.eventinfofragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.databinding.FragmentEventDetailsBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity

class EventDetailsFragment : Fragment() {
    private lateinit var binding: FragmentEventDetailsBinding
    private lateinit var chosenEvent: Event
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventDetailsBinding.inflate(
            inflater, container, false
        )

        viewModel = (activity as MainActivity).eventViewModel
        chosenEvent = viewModel.chosenEvent

        binding.apply {
            eventTitleText.text = chosenEvent.name
            eventDateText.text = chosenEvent.dates.start.localDate
            eventArtistText.text = chosenEvent._embedded.attractions[0].name
            eventVenueTxt.text = chosenEvent._embedded.venues[0].name
            eventGenreText.text = "${chosenEvent.classifications[0].genre.name} | " +
                    "${chosenEvent.classifications[0].subGenre.name} | " +
                    "${chosenEvent.classifications[0].segment.name}"

            eventPriceRangeTxt.text =
                "${chosenEvent.priceRanges[0].min} - ${chosenEvent.priceRanges[0].max}"
            eventTicketStatusTxt.text = chosenEvent.dates.status.code

            val seatMapUrl = chosenEvent.seatmap.staticUrl
            Glide.with(seatMapImage.context).load(seatMapUrl).into(seatMapImage)

            ticketMasterLinkTxt.setOnClickListener {
                val url = chosenEvent.url
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)

                startActivity(intent)
            }

            saveEventToFavorites.setOnClickListener {
                checkIfEventExists()
            }

            btnShareOnFacebook.setOnClickListener {
                shareOnFacebook()
            }
            btnShareOnTwitter.setOnClickListener {
                shareOnTwitter()
            }
        }
        return binding.root
    }

    private fun shareOnTwitter() {
        val tweetUrl = "https://twitter.com/intent/tweet?text=${chosenEvent.url}"
        val uri = Uri.parse(tweetUrl)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }

    private fun shareOnFacebook() {
        val facebookUrl = "https://www.facebook.com/sharer/sharer.php?u=${chosenEvent.url}"
        val uri = Uri.parse(facebookUrl)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }

    private fun checkIfEventExists() {
        /*val existingEvent = viewModel.getEventId(chosenEvent.id)
        if (existingEvent.toString().isNotBlank()) {
            viewModel.deleteEventFromFavorite(chosenEvent)
        } else {

        }*/
        viewModel.saveEventToFavorite(chosenEvent)
        Toast.makeText(
            (activity as MainActivity).applicationContext,
            "Added to favorites",
            Toast.LENGTH_SHORT
        ).show()
    }

}