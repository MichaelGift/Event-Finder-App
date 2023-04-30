package com.myth.ticketmasterapp.presentation.fragments.eventinfofragments

import com.myth.ticketmasterapp.data.eventdatamodels.Event
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.databinding.FragmentArtistTeamInfoBinding

class ArtistTeamInfoFragment() : Fragment() {

    private lateinit var binding:FragmentArtistTeamInfoBinding
    lateinit var chosenEvent: Event

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist_team_info, container, false)
    }
}