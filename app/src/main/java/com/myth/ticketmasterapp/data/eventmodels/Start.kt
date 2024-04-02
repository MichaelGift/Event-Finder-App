package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Start(
    val dateTBA: Boolean,
    val dateTBD: Boolean,
    val localDate: String,
    val localTime: String,
    val noSpecificTime: Boolean,
    val timeTBA: Boolean
) : Parcelable