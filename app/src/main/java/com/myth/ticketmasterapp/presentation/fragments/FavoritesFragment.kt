package com.myth.ticketmasterapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.databinding.FragmentFavoritesBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity
import com.myth.ticketmasterapp.presentation.adapter.FavoritesFragmentAdapter

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var eventsViewModel: EventViewModel
    private lateinit var favoriteFragmentAdapter: FavoritesFragmentAdapter
    private lateinit var eventsList: List<Event>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(
            inflater, container, false
        )

        eventsViewModel = (activity as MainActivity).eventViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        favoriteFragmentAdapter = FavoritesFragmentAdapter(eventsViewModel, this)

        binding.favoritesRecyclerView.apply {
            layoutManager = LinearLayoutManager((activity as MainActivity).applicationContext)
            adapter = favoriteFragmentAdapter
        }

        getEventsList()
    }

    fun getEventsList() {
        (activity as MainActivity).let {
            eventsViewModel.getFavoriteEvents().observe(
                viewLifecycleOwner
            ) { event ->
                favoriteFragmentAdapter.differ.submitList(event)
                if (event != null) {
                    eventsList = event
                }
                updateUI(event)
            }
        }
    }

    private fun updateUI(event: List<Event>?) {
        binding.eventResultProgressBar.visibility = View.VISIBLE
        if (event != null) {
            if (event.isNotEmpty()) {
                binding.cardView2.visibility = View.GONE
                binding.favoritesRecyclerView.visibility = View.VISIBLE
                binding.eventResultProgressBar.visibility = View.GONE
            } else {
                binding.cardView2.visibility = View.VISIBLE
                binding.favoritesRecyclerView.visibility = View.GONE
                binding.eventResultProgressBar.visibility = View.GONE
            }
        }
    }
}