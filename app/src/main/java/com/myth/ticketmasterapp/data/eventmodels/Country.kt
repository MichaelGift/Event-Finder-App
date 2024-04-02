package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val countryCode: String,
    val name: String
):Parcelable