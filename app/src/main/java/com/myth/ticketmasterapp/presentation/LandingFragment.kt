package com.myth.ticketmasterapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.myth.ticketmasterapp.databinding.FragmentLandingBinding
import com.myth.ticketmasterapp.presentation.viewpager.LandingPageViewPagerAdapter

class LandingFragment : Fragment() {
    private lateinit var binding: FragmentLandingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLandingBinding.inflate(
            inflater, container, false
        )
//        val landingPageAdapter = LandingPageViewPagerAdapter(
////            (activity as MainActivity).supportFragmentManager, lifecycle
//        )

        binding.apply {
//            viewPager.adapter = landingPageAdapter
            val tabTitle = generateTabTitles()

            TabLayoutMediator(tabViewNav, viewPager){tab, position ->
                tab.text = tabTitle[position]
            }.attach()
        }
        return binding.root
    }

    private fun generateTabTitles(): List<String> {

        return arrayListOf("SEARCH", "FAVORITES")

    }
}