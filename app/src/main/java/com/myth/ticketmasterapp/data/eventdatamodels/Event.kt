package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "events")
@Parcelize
data class Event(
    val _embedded: com.myth.ticketmasterapp.data.eventdatamodels.EmbeddedX,
    val ageRestrictions: com.myth.ticketmasterapp.data.eventdatamodels.AgeRestrictions,
    val classifications: List<com.myth.ticketmasterapp.data.eventdatamodels.ClassificationX>,
    val dates: com.myth.ticketmasterapp.data.eventdatamodels.Dates,
    @PrimaryKey
    val id: String,
    val images: List<com.myth.ticketmasterapp.data.eventdatamodels.ImageXX>,
    val info: String,
    val locale: String,
    val name: String,
    val pleaseNote: String,
    val priceRanges: List<com.myth.ticketmasterapp.data.eventdatamodels.PriceRange>,
    val promoters: List<com.myth.ticketmasterapp.data.eventdatamodels.Promoter>,
    val sales: com.myth.ticketmasterapp.data.eventdatamodels.Sales,
    val seatmap: com.myth.ticketmasterapp.data.eventdatamodels.Seatmap,
    val test: Boolean,
    val type: String,
    val url: String
) : Parcelable