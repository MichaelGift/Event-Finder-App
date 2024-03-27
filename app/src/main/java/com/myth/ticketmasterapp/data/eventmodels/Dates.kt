package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(
    val spanMultipleDays: Boolean,
    val start: com.myth.ticketmasterapp.data.eventmodels.Start,
    val status: com.myth.ticketmasterapp.data.eventmodels.Status,
    val timezone: String
):Parcelable