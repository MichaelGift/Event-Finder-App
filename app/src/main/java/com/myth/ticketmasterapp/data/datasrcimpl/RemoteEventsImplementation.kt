package com.myth.ticketmasterapp.data.datasrcimpl

import com.myth.ticketmasterapp.data.api.TicketMasterService
import com.myth.ticketmasterapp.data.datasrc.RemoteEvents
import com.myth.ticketmasterapp.data.eventmodels.EventsData
import retrofit2.Response

class RemoteEventsImplementation(
    private val ticketMasterService: TicketMasterService,
    private val apikey: String
) : RemoteEvents {
    override suspend fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): Response<EventsData> =
        ticketMasterService.getEventByName(apikey, keyword, distance, category, location)

}