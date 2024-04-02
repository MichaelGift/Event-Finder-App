package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "events")
data class Event(
    @SerializedName("_embedded")
    val venueData: VenueData,
    val classifications: List<Classification>,
    val dates: Dates,
    @PrimaryKey
    val id: String,
    @SerializedName("images")
    val posters: List<Posters>,
    val info: String,
    val name: String,
    val pleaseNote: String,
    val priceRanges: List<PriceRange>,
    val ticketSales: Sales,
    val seatmap: Seatmap,
    val type: String,
    val url: String
)
