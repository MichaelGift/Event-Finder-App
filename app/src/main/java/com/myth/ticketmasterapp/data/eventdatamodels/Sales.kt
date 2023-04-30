package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sales(
    val presales: List<com.myth.ticketmasterapp.data.eventdatamodels.Presale>,
    val `public`: com.myth.ticketmasterapp.data.eventdatamodels.Public
):Parcelable