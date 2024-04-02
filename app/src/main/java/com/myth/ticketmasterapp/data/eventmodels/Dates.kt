package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(
    val spanMultipleDays: Boolean,
    val start: Start,
    val status: Status,
    val timezone: String
):Parcelable