package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Market(
    val id: String,
    val name: String
):Parcelable