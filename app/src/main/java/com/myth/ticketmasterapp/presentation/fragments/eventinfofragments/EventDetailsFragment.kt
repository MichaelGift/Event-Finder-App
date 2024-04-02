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
import com.myth.ticketmasterapp.data.eventmodels.Event
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


            for (venueName in chosenEvent.venueData.venues) {
                eventVenueTxt.text = venueName.name
                break
            }
            for (classifications in chosenEvent.classifications) {
                eventGenreText.text =
                    "${classifications.segment.name} | ${classifications.genre.name} | ${classifications.subGenre.name}"
                break
            }

            val priceRanges = chosenEvent?.priceRanges

            if (priceRanges != null) {
                for (prices in priceRanges) {
                    "${prices.min} -${prices.max}".also { eventPriceRangeTxt.text = it }
                    break
                }
            }

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
                val eventsInfo = chosenEvent?.info?.toString()
                if (eventsInfo != null) {
                    checkIfEventExists()
                } else {
                    Toast.makeText(
                        (activity as MainActivity).applicationContext,
                        "This event has some null parameters, Cannot be saved",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            btnShareOnFacebook.setOnClickListener {
                shareOnFacebook()
            }
            btnShareOnTwitter.setOnClickListener {
                shareOnTwitter()
            }
        }
        println("Current event ID is${chosenEvent.id}")
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
        viewModel.getEventId(chosenEvent.id.trim()).observe(
            viewLifecycleOwner
        ) { event ->
            if (event == null) {
                viewModel.saveEventToFavorite(chosenEvent)
                Toast.makeText(
                    (activity as MainActivity).applicationContext,
                    "Added to favorites",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.deleteEventFromFavorite(chosenEvent)
                Toast.makeText(
                    (activity as MainActivity).applicationContext,
                    "Removed From Favorites",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}