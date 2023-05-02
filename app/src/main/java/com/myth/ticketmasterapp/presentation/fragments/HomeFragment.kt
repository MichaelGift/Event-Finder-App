package com.myth.ticketmasterapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.myth.ticketmasterapp.R
import com.myth.ticketmasterapp.databinding.FragmentHomeBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.MainActivity
import com.myth.ticketmasterapp.presentation.ResultsFragment

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var eventsViewModel: EventViewModel
    /*private lateinit var eventsAdapter: HomeFragmentAdapter*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventsViewModel = (activity as MainActivity).eventViewModel
        val categories = arrayOf("All", "Music", "Sport", "Arts & Theatre", "Film", "Misc")
        val adapter = ArrayAdapter(
            (activity as MainActivity).applicationContext,
            R.layout.dropdown_layout,
            categories
        )

        binding.locationSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.locationEditText.visibility = View.GONE
            } else {
                binding.locationEditText.visibility = View.VISIBLE
            }
        }

        binding.eventCategoryDropdown.adapter = adapter
        /*setUpRecyclerView()*/

        binding.btnSubmitSearchQueries.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.homeFragmentToResultFragment, ResultsFragment())
            transaction.commit()

            val keyword: String = binding.keyWordEditText.text.toString()
            val distance: String = ""
            val category: String = ""
            val location: String = ""

            eventsViewModel.getEvent(keyword, distance, category, location).observe(viewLifecycleOwner,
                Observer {  })
        }

        /*private fun setUpRecyclerView() {
            eventsAdapter = HomeFragmentAdapter()

            eventsViewModel.homeFragmentAdapter = eventsAdapter

            *//*binding.resultsRecyclerView.apply {
            layoutManager = LinearLayoutManager((activity as MainActivity).applicationContext)
            adapter = eventsAdapter
        }*//*
    }*/

        /*private fun updateUI(event: List<Event>) {
            binding.searchResultProgressBar.visibility = View.VISIBLE

            if (event != null) {
                if (event.isNotEmpty()) {
                    binding.resultsTextView.visibility = View.VISIBLE
                    binding.resultsRecyclerView.visibility = View.VISIBLE
                    binding.searchResultProgressBar.visibility = View.GONE
                } else {
                    binding.resultsTextView.visibility = View.GONE
                    binding.resultsRecyclerView.visibility = View.GONE
                    binding.searchResultProgressBar.visibility = View.GONE

                    Toast.makeText(
                        ((activity as MainActivity).applicationContext),
                        "No Events Available",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }*/

        /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            menu.clear()
            inflater.inflate(R.menu.home_menu, menu)
            super.onCreateOptionsMenu(menu, inflater)
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.favoritesIcon -> {
                    view?.findNavController()?.navigate(R.id.action_homeFragment_to_favoritesFragment)
                }
            }
            return super.onOptionsItemSelected(item)*/
    }
}