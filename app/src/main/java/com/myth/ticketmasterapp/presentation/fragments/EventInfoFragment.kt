package com.myth.ticketmasterapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.data.eventmodels.TabIconData
import com.myth.ticketmasterapp.databinding.FragmentEventInfoBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity

class EventInfoFragment : Fragment() {
    private lateinit var binding: FragmentEventInfoBinding

    private lateinit var currentEvent: Event

    private lateinit var viewModel: EventViewModel

//    private val args: EventInfoFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentEventInfoBinding.inflate(inflater, container, false)

//        val eventAdapter = EventInfoViewPagerAdapter(
//            (activity as MainActivity).supportFragmentManager, lifecycle
//        )

        binding.apply {
//            viewPager.adapter = eventAdapter
            val iconset = generateIcons()

            TabLayoutMediator(tabViewNav, viewPager) { tab, position ->
                tab.icon = ContextCompat.getDrawable(
                    (activity as MainActivity),
                    iconset[position].activeTabIcon
                )
            }.attach()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        currentEvent = args.event!!

        viewModel = (activity as MainActivity).eventViewModel

        viewModel.chosenEvent = currentEvent
    }


    private fun generateIcons(): ArrayList<TabIconData> {
        val icons = ArrayList<TabIconData>()

        val eventDetailsIcon = TabIconData(R.drawable.ic_events)
        val artistTeamIcon = TabIconData(R.drawable.ic_artist)
        val venueicon = TabIconData(R.drawable.ic_venue)

        icons.add(eventDetailsIcon)
        icons.add(artistTeamIcon)
        icons.add(venueicon)

        return icons
    }


}