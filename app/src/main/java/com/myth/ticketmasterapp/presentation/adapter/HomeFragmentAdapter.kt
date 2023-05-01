package com.myth.ticketmasterapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.databinding.EventSearchResultsCardLayoutBinding
import com.myth.ticketmasterapp.presentation.fragments.HomeFragmentDirections

class HomeFragmentAdapter : RecyclerView.Adapter<HomeFragmentAdapter.EventsViewHolder>() {

    class EventsViewHolder(val itemBinding: EventSearchResultsCardLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Event>() {
        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.id == newItem.id
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
        holder.itemBinding.eventSearchResultDateAndTime.text = currentEvent.dates.start.localDate


        for (venue in currentEvent._embedded.venues) {
            holder.itemBinding.eventSearchResultVenue.text = venue.name
            break
        }

        for (posters in currentEvent.images) {
            val posterUrl = posters.url
            Glide.with(holder.itemBinding.eventSearchResultImage.context).load(posterUrl)
                .into(holder.itemBinding.eventSearchResultImage)
            break
        }




        holder.itemView.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToEventInfoFragment(currentEvent)
            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}