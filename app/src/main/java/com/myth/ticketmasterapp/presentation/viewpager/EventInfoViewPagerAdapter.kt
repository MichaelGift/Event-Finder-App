package com.myth.ticketmasterapp.presentation.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myth.ticketmasterapp.presentation.fragments.eventinfofragments.ArtistTeamInfoFragment
import com.myth.ticketmasterapp.presentation.fragments.eventinfofragments.EventDetailsFragment
import com.myth.ticketmasterapp.presentation.fragments.eventinfofragments.VenueInfoFragment

class EventInfoViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return EventDetailsFragment()
            1 -> return ArtistTeamInfoFragment()
            else -> return VenueInfoFragment()
        }
    }
}