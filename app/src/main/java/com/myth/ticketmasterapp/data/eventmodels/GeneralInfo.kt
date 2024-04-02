package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GeneralInfo(
    val childRule: String,
    val generalRule: String
):Parcelable