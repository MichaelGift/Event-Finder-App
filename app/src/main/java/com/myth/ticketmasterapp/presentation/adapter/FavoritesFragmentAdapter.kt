package com.myth.ticketmasterapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.databinding.EventSearchResultsCardLayoutBinding
import com.myth.ticketmasterapp.presentation.EventViewModel
import com.myth.ticketmasterapp.presentation.fragments.FavoritesFragment

class FavoritesFragmentAdapter(
    val eventViewModel: EventViewModel,
    val favoritesFragment: FavoritesFragment
) :
    RecyclerView.Adapter<FavoritesFragmentAdapter.EventsViewHolder>() {

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
        holder.itemBinding.eventSearchResultDate.text = currentEvent.dates.start.localDate
        for (venue in currentEvent.venueData.venues) {
            holder.itemBinding.eventSearchResultVenue.text = venue.name
            break
        }

        for (image in currentEvent.posters) {
            val posterUrl = currentEvent.posters[0].url
            Glide.with(holder.itemBinding.eventSearchResultImage.context).load(posterUrl)
                .into(holder.itemBinding.eventSearchResultImage)

            break
        }

        holder.itemView.setOnClickListener {
            eventViewModel.deleteEventFromFavorite(currentEvent)
                .observe(favoritesFragment.viewLifecycleOwner,
                    Observer { })
            favoritesFragment.getEventsList()
            Toast.makeText(
                holder.itemView.context, "Removed from favorites", Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}