package com.myth.ticketmasterapp.data.eventdatamodels

import com.google.gson.annotations.SerializedName

data class EventsData(
    @SerializedName("_embedded")
    val embedded: Embedded
)