package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageXX(
    val fallback: Boolean,
    val height: Int,
    val ratio: String,
    val url: String,
    val width: Int
):Parcelable