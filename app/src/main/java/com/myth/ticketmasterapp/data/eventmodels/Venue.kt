package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Venue(
    val address: Address,
    val location: Location,
    val name: String,
    val url: String
) : Parcelable