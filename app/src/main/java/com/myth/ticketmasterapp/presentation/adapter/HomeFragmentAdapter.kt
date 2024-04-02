package com.myth.ticketmasterapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.databinding.EventSearchResultsCardLayoutBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.LandingFragmentDirections
import com.myth.ticketmasterapp.presentation.ResultsFragment

class HomeFragmentAdapter(
    val eventViewModel: EventViewModel,
    val resultsFragment: ResultsFragment
) :
    RecyclerView.Adapter<HomeFragmentAdapter.EventsViewHolder>() {

    class EventsViewHolder(val itemBinding: EventSearchResultsCardLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {}

    private val differCallback = object : DiffUtil.ItemCallback<Event>() {
        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.type == newItem.type
                    && oldItem.id == newItem.id
                    && oldItem.url == newItem.url
                    && oldItem.locale == newItem.locale
                    && oldItem.posters == newItem.posters
                    && oldItem.ticketSales == newItem.ticketSales
                    && oldItem.dates == newItem.dates
                    && oldItem.classifications == newItem.classifications
                    && oldItem.promoters == newItem.promoters
                    && oldItem.priceRanges == newItem.priceRanges
                    && oldItem.seatmap == newItem.seatmap
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        return EventsViewHolder(
            EventSearchResultsCardLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val currentEvent = differ.currentList[position]
        holder.itemBinding.eventSearchResultTitle.text = currentEvent.name

        val dates = currentEvent.dates?.start
        if (dates != null) {
            holder.itemBinding.eventSearchResultDate.text = dates.localDate
            holder.itemBinding.eventSearchResultTime.text = dates.localTime
        } else {
            holder.itemBinding.eventSearchResultDate.text = "Date TBA"
            holder.itemBinding.eventSearchResultTime.text = "Time TBA"
        }


        val classifications = currentEvent.classifications?.get(0)
        if (classifications != null) {
            holder.itemBinding.eventSearchResultCategory.text = classifications.segment.name
        } else {
            holder.itemBinding.eventSearchResultTime.text = "Category TBA"
        }

        if (currentEvent.venueData.venues.isNotEmpty()) {
            holder.itemBinding.eventSearchResultVenue.text = currentEvent.venueData.venues[0].name
        }

        for (posters in currentEvent.posters) {
            val posterUrl = posters.url
            Glide.with(holder.itemBinding.eventSearchResultImage.context).load(posterUrl)
                .into(holder.itemBinding.eventSearchResultImage)
            break
        }

        holder.itemBinding.btnAddToFavorite.setOnClickListener {
            val eventsInfo = currentEvent?.info?.toString()
            if (eventsInfo != null) {
                eventViewModel.saveEventToFavorite(currentEvent)
                    .observe(resultsFragment.viewLifecycleOwner, Observer { })

                Toast.makeText(
                    holder.itemView.context,
                    "Added to favorites",
                    Toast.LENGTH_LONG
                ).show()

                holder.itemBinding.btnRemoveFromFavorite.visibility = View.VISIBLE
                holder.itemBinding.btnAddToFavorite.visibility = View.GONE
            } else {
                Toast.makeText(
                    holder.itemView.context,
                    "This event has missing information",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        holder.itemBinding.btnRemoveFromFavorite.setOnClickListener {
            eventViewModel.deleteEventFromFavorite(currentEvent)
                .observe(resultsFragment.viewLifecycleOwner, Observer { })

            Toast.makeText(
                holder.itemView.context,
                "Removed from favorites",
                Toast.LENGTH_LONG
            )
                .show()

            holder.itemBinding.btnAddToFavorite.visibility = View.VISIBLE
            holder.itemBinding.btnRemoveFromFavorite.visibility = View.GONE

        }

        holder.itemView.setOnClickListener {
            val direction =
                LandingFragmentDirections.actionLandingFragment2ToEventInfoFragment(currentEvent)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}