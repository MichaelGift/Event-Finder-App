package com.myth.ticketmasterapp.data.datasource

import com.myth.ticketmasterapp.data.eventdatamodels.SampleEvent
import retrofit2.Response

interface EventRemoteDataSource {
    suspend fun getEvent(): Response<SampleEvent>

}