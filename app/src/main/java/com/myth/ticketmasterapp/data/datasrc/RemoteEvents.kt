package com.myth.ticketmasterapp.data.datasrc

import com.myth.ticketmasterapp.data.eventmodels.EventsData
import retrofit2.Response

interface RemoteEvents {
    suspend fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): Response<EventsData>

}