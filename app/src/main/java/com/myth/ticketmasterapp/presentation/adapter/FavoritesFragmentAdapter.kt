package com.myth.ticketmasterapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.databinding.EventSearchResultsCardLayoutBinding
import com.myth.ticketmasterapp.presentation.EventViewModel

class FavoritesFragmentAdapter : RecyclerView.Adapter<FavoritesFragmentAdapter.EventsViewHolder>() {

    private lateinit var eventViewModel: EventViewModel
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
        holder.itemBinding.eventSearchResultVenue.text = currentEvent._embedded.venues[0].name

        val posterUrl = currentEvent.images[0].url

        Glide.with(holder.itemBinding.eventSearchResultImage.context).load(posterUrl)
            .into(holder.itemBinding.eventSearchResultImage)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}