package com.myth.ticketmasterapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.databinding.FragmentResultsBinding
import com.myth.ticketmasterapp.presentation.adapter.HomeFragmentAdapter
import com.myth.ticketmasterapp.presentation.fragments.HomeFragment

class ResultsFragment : Fragment() {
    private lateinit var binding: FragmentResultsBinding
    private lateinit var homeFragmentAdapter: HomeFragmentAdapter
    private lateinit var eventViewModel: EventViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        eventViewModel = (activity as MainActivity).eventViewModel

        binding.backToSearchView.setOnClickListener {

            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.homeFragmentToResultFragment, HomeFragment())
            transaction.commit()
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        homeFragmentAdapter = HomeFragmentAdapter(eventViewModel, this)

        binding.resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager((activity as MainActivity).applicationContext)
            adapter = homeFragmentAdapter
        }

        val responseLiveData = eventViewModel.listEvents
        responseLiveData.observe(viewLifecycleOwner, Observer { eventList ->
            homeFragmentAdapter.differ.submitList(eventList)
            println("You have found the following events ${eventList?.size}")

            if (eventList != null) {
                updateUI(eventList)
            }
        })

    }

    private fun updateUI(event: List<Event>) {
        binding.searchResultProgressBar.visibility = View.VISIBLE

        if (event != null) {
            if (event.isNotEmpty()) {
                binding.resultsRecyclerView.visibility = View.VISIBLE
                binding.searchResultProgressBar.visibility = View.GONE
            } else {
                binding.resultsRecyclerView.visibility = View.GONE
                binding.searchResultProgressBar.visibility = View.GONE

                Toast.makeText(
                    ((activity as MainActivity).applicationContext),
                    "No Events Available",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}