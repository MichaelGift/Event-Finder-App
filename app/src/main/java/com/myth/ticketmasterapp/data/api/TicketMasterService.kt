package com.myth.ticketmasterapp.data.api

import com.myth.ticketmasterapp.data.eventdatamodels.SampleEvent
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TicketMasterService {
    @GET("events")
    suspend fun getEventByName(
        @Query("apikey") apikey: String): Response<SampleEvent>
}