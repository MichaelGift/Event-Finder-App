package com.myth.ticketmasterapp.domain.repository

import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import retrofit2.Call

interface EventRepository {

    suspend fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): List<Event>?

    suspend fun saveEvent(event: Event)
    suspend fun getEventsFromDB(): List<Event>?
    suspend fun deleteEvent(event: Event)
    suspend fun getEventById(eventId: String)
    suspend fun getSpotifyData(authorization: String, artistName: String): List<SpotifyData>?
    fun getAccessToken(authorization: String, getToken: String): Call<AccessTokenResponse>
}