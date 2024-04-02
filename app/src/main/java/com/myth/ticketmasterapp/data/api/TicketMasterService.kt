package com.myth.ticketmasterapp.data.api

import com.myth.ticketmasterapp.data.eventmodels.EventsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface TicketMasterService {
    @Headers("Cache-Control: max-age=3600")
    @GET("events")
    suspend fun getEventByName(
        @Query("apikey") apikey: String,
        @Query("keyword") keyword: String,
        @Query("unity") distance: String,
        @Query("classificationName") category: String,
        @Query("geoPoint") location: String
    ): Response<EventsData>
}