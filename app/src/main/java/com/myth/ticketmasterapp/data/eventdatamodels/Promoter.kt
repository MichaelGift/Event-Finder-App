package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Promoter(
    val description: String,
    val id: String,
    val name: String
):Parcelable