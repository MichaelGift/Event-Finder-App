package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Posters(
    val fallback: Boolean,
    val height: Int,
    val ratio: String,
    val url: String,
    val width: Int
):Parcelable