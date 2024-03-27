package com.myth.ticketmasterapp.presentation.fragments.eventinfofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import com.myth.ticketmasterapp.databinding.FragmentArtistTeamInfoBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity
import com.myth.ticketmasterapp.presentation.adapter.EventSpotifyArtistInfoAdapter

class ArtistTeamInfoFragment() : Fragment() {
    private lateinit var binding: FragmentArtistTeamInfoBinding
    private lateinit var eventViewModel: EventViewModel
    private lateinit var eventSpotifyArtistInfoAdapter: EventSpotifyArtistInfoAdapter

    lateinit var chosenEvent: Event

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistTeamInfoBinding.inflate(
            inflater, container, false
        )
        eventViewModel = (activity as MainActivity).eventViewModel
        chosenEvent = eventViewModel.chosenEvent
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun updateUI(spotifyData: List<SpotifyData>) {
        if (spotifyData != null) {
            if (spotifyData.isNotEmpty()) {
                binding.noFavoriteEventTXt.visibility = View.GONE
                binding.spotifyRecyclerView.visibility = View.VISIBLE
            } else {
                binding.noFavoriteEventTXt.visibility = View.VISIBLE
                binding.spotifyRecyclerView.visibility = View.GONE
            }
        }
    }

    private fun setUpRecyclerView() {
        eventSpotifyArtistInfoAdapter = EventSpotifyArtistInfoAdapter()

        binding.spotifyRecyclerView.apply {
            layoutManager = LinearLayoutManager((activity as MainActivity).applicationContext)
            adapter = eventSpotifyArtistInfoAdapter
        }
    }
}