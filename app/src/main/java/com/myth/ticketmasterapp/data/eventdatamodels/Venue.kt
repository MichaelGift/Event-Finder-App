package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    val _links: com.myth.ticketmasterapp.data.eventdatamodels.Links,
    val accessibleSeatingDetail: String,
    val address: com.myth.ticketmasterapp.data.eventdatamodels.Address,
    val boxOfficeInfo: com.myth.ticketmasterapp.data.eventdatamodels.BoxOfficeInfo,
    val city: com.myth.ticketmasterapp.data.eventdatamodels.City,
    val country: com.myth.ticketmasterapp.data.eventdatamodels.Country,
    val dmas: List<com.myth.ticketmasterapp.data.eventdatamodels.Dma>,
    val generalInfo: com.myth.ticketmasterapp.data.eventdatamodels.GeneralInfo,
    val id: String,
    val locale: String,
    val location: com.myth.ticketmasterapp.data.eventdatamodels.Location,
    val markets: List<com.myth.ticketmasterapp.data.eventdatamodels.Market>,
    val name: String,
    val parkingDetail: String,
    val postalCode: String,
    val state: com.myth.ticketmasterapp.data.eventdatamodels.State,
    val test: Boolean,
    val timezone: String,
    val type: String,
    val url: String
):Parcelable