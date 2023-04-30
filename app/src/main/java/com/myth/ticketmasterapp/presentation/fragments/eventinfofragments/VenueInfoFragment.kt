package com.myth.ticketmasterapp.presentation.fragments.eventinfofragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.databinding.FragmentVenuInfoBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity

class VenueInfoFragment() : Fragment() {
    private lateinit var binding: FragmentVenuInfoBinding
    private lateinit var chosenEvent: Event
    private lateinit var viewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVenuInfoBinding.inflate(
            inflater, container, false
        )
        viewModel = (activity as MainActivity).eventViewModel
        chosenEvent = viewModel.chosenEvent

        binding.apply {
            eventTitleTxt.text = chosenEvent._embedded.venues[0].name
            eventStadiumNameTxt.text = chosenEvent._embedded.venues[0].name
            eventVenueAddress.text = chosenEvent._embedded.venues[0].address.line1
            eventVenuePhoneNumberTxt.text =
                chosenEvent._embedded.venues[0].boxOfficeInfo.phoneNumberDetail
            eventVenueOpenHoursTxt.text =
                chosenEvent._embedded.venues[0].boxOfficeInfo.openHoursDetail
            eventVenueGeneralRule.text = chosenEvent._embedded.venues[0].generalInfo.generalRule
            eventVenueChildRuleTxt.text = chosenEvent._embedded.venues[0].generalInfo.childRule

            btnShowVenueOnMaps.setOnClickListener {
                val latitude = chosenEvent._embedded.venues[0].location.latitude
                val longitude = chosenEvent._embedded.venues[0].location.longitude
                val label = chosenEvent._embedded.venues[0].name

                val locationUri = Uri.parse("geo:$latitude,$longitude?q=$label")

                val mapIntent = Intent(Intent.ACTION_VIEW, locationUri)
                startActivity(mapIntent)
            }
        }

        return binding.root
    }
}