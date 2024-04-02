package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ClassificationX(
    val genre: Genre,
    val segment: Segment,
    val subGenre: SubGenre
):Parcelable
