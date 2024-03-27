package com.myth.ticketmasterapp.presentation.fragments.eventinfofragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.databinding.FragmentVenuInfoBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity

class VenueInfoFragment : Fragment() {
    private lateinit var binding: FragmentVenuInfoBinding
    private lateinit var chosenEvent: Event
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVenuInfoBinding.inflate(
            inflater, container, false
        )
        viewModel = (activity as MainActivity).eventViewModel

        chosenEvent = viewModel.chosenEvent

        binding.apply {


            for (venue in chosenEvent.venueData.venues) {
                eventTitleTxt.text = venue.name
                eventStadiumNameTxt.text = venue.name
                eventVenueAddress.text = venue.address.line1

                btnShowVenueOnMaps.setOnClickListener {
                    val latitude = venue.location.latitude
                    val longitude = venue.location.longitude
                    val label = venue.name

                    val locationUri = Uri.parse("geo:$latitude,$longitude?q=$label")

                    val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)
                    startActivity(mapIntent)
                }

                break
            }

        }

        return binding.root
    }
}