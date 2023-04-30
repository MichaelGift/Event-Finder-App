package com.myth.ticketmasterapp.data.datasourceimplementation

import com.myth.ticketmasterapp.data.api.TicketMasterService
import com.myth.ticketmasterapp.data.datasource.EventRemoteDataSource
import com.myth.ticketmasterapp.data.eventdatamodels.SampleEvent
import retrofit2.Response

class EventRemoteDataSourceImplementation(
    private val ticketMasterService: TicketMasterService,
    private val apikey: String
) : EventRemoteDataSource {
    override suspend fun getEvent(): Response<SampleEvent> =
        ticketMasterService.getEventByName(apikey)

}