package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmbeddedX(
    val attractions: List<com.myth.ticketmasterapp.data.eventdatamodels.Attraction>,
    val venues: List<com.myth.ticketmasterapp.data.eventdatamodels.Venue>
):Parcelable