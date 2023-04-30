package com.myth.ticketmasterapp.data.eventdatamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Classification(
    val genre: com.myth.ticketmasterapp.data.eventdatamodels.Genre,
    val segment: com.myth.ticketmasterapp.data.eventdatamodels.Segment,
    val subGenre: com.myth.ticketmasterapp.data.eventdatamodels.SubGenre,
):Parcelable