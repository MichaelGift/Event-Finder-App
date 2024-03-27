package com.myth.ticketmasterapp.data.eventmodels

import com.google.gson.annotations.SerializedName

data class EventsData(
    @SerializedName("_embedded")
    val embedded: Embedded
)