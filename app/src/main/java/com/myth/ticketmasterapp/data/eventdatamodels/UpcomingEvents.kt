package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpcomingEvents(
    val _filtered: Int,
    val _total: Int,
    val ticketmaster: Int
):Parcelable