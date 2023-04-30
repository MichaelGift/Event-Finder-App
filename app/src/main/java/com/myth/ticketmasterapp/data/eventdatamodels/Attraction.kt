package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attraction(
    val _links: com.myth.ticketmasterapp.data.eventdatamodels.Links,
    val aliases: List<String>,
    val classifications: List<com.myth.ticketmasterapp.data.eventdatamodels.Classification>,
    val externalLinks: com.myth.ticketmasterapp.data.eventdatamodels.ExternalLinks,
    val id: String,
    val images: List<ImageXX>,
    val locale: String,
    val name: String,
    val test: Boolean,
    val type: String,
    val upcomingEvents: com.myth.ticketmasterapp.data.eventdatamodels.UpcomingEvents,
    val url: String
):Parcelable