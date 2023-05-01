package com.myth.ticketmasterapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import com.myth.ticketmasterapp.databinding.SpotifyArtistCardLayoutBinding

class EventSpotifyArtistInfoAdapter :
    RecyclerView.Adapter<EventSpotifyArtistInfoAdapter.EventSpotifyArtistInfoViewHolder>() {

    class EventSpotifyArtistInfoViewHolder(val itemBinding: SpotifyArtistCardLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<SpotifyData>() {
        override fun areItemsTheSame(oldItem: SpotifyData, newItem: SpotifyData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: SpotifyData, newItem: SpotifyData): Boolean {
            return oldItem.artists.items[0].id == newItem.artists.items[0].id
        }
    }
    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventSpotifyArtistInfoViewHolder {
        return EventSpotifyArtistInfoViewHolder(
            SpotifyArtistCardLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: EventSpotifyArtistInfoViewHolder, position: Int) {
        val currentArtisData = differ.currentList[position]

        holder.itemBinding.spotifyArtistName.text = currentArtisData.artists.items[0].name
        holder.itemBinding.spotifyArtistFollowers.text =
            currentArtisData.artists.items[0].followers.total.toString()
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}