package com.myth.ticketmasterapp.data.eventmodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Classification(
    val genre: com.myth.ticketmasterapp.data.eventmodels.Genre,
    val segment: com.myth.ticketmasterapp.data.eventmodels.Segment,
    val subGenre: com.myth.ticketmasterapp.data.eventmodels.SubGenre,
):Parcelable