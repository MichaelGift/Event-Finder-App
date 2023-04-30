package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Start(
    val dateTBA: Boolean,
    val dateTBD: Boolean,
    val localDate: String,
    val noSpecificTime: Boolean,
    val timeTBA: Boolean
):Parcelable