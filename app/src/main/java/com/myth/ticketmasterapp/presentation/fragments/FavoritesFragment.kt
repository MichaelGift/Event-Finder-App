package com.myth.ticketmasterapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.databinding.FragmentFavoritesBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity
import com.myth.ticketmasterapp.presentation.adapter.FavoritesFragmentAdapter

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var eventsViewModel: EventViewModel
    private lateinit var favoriteFragmentAdapter: FavoritesFragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(
            inflater, container, false
        )

        eventsViewModel =(activity as MainActivity).eventViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        favoriteFragmentAdapter = FavoritesFragmentAdapter()

        binding.favoritesRecyclerView.apply {
            layoutManager = LinearLayoutManager((activity as MainActivity).applicationContext)
            adapter = favoriteFragmentAdapter
        }


        (activity as MainActivity).let {
            eventsViewModel.getFavoriteEvents().observe(
                viewLifecycleOwner
            ){
                    event->
                favoriteFragmentAdapter.differ.submitList(event)
                updateUI(event)
            }
        }
    }

    private fun updateUI(event: List<Event>?) {
        if (event != null){
            if(event.isNotEmpty()){
                binding.noFavoriteEventTXt.visibility = View.GONE
                binding.favoritesRecyclerView.visibility = View.VISIBLE
            }else{
                binding.noFavoriteEventTXt.visibility = View.VISIBLE
                binding.favoritesRecyclerView.visibility = View.GONE
            }
        }
    }
}