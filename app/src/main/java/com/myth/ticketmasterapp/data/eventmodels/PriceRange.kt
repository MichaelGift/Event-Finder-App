package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PriceRange(
    val currency: String,
    val max: Double,
    val min: Double,
    val type: String
):Parcelable