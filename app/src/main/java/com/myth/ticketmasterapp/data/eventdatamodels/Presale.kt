package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Presale(
    val endDateTime: String,
    val name: String,
    val startDateTime: String
):Parcelable