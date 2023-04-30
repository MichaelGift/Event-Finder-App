package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dates(
    val spanMultipleDays: Boolean,
    val start: com.myth.ticketmasterapp.data.eventdatamodels.Start,
    val status: com.myth.ticketmasterapp.data.eventdatamodels.Status,
    val timezone: String
):Parcelable