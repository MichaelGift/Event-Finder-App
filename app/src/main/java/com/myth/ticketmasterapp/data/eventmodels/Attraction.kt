package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attraction(
    val _links: Links,
    val aliases: List<String>,
    val classifications: List<Classification>,
    val externalLinks: ExternalLinks,
    val id: String,
    val images: List<Posters>,
    val locale: String,
    val name: String,
    val test: Boolean,
    val type: String,
    val upcomingEvents: UpcomingEvents,
    val url: String
) : Parcelable