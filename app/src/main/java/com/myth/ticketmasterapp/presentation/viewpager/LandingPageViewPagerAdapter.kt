package com.myth.ticketmasterapp.presentation.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.myth.ticketmasterapp.presentation.fragments.FavoritesFragment
import com.myth.ticketmasterapp.presentation.fragments.HomeFragment

class LandingPageViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            else -> return FavoritesFragment()
        }
    }

}