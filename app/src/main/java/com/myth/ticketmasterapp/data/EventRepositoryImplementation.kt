package com.myth.ticketmasterapp.data

import android.util.Log
import com.myth.ticketmasterapp.data.datasource.EventCacheDataSource
import com.myth.ticketmasterapp.data.datasource.EventLocalDataSource
import com.myth.ticketmasterapp.data.datasource.EventRemoteDataSource
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.data.spotifydatamodels.SpotifyData
import com.myth.ticketmasterapp.domain.repository.EventRepository
import retrofit2.Call

class EventRepositoryImplementation(
    private val eventRemoteDataSource: EventRemoteDataSource,
    private val eventLocalDataSource: EventLocalDataSource,
    private val eventCacheDataSource: EventCacheDataSource,
    private val spotifyRemoteDataSource: SpotifyRemoteDataSource
) : EventRepository {
    override suspend fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): List<Event>? {
        return getEventsFromAPI(keyword, distance, category, location)
    }

    override suspend fun saveEvent(event: Event) {
        return eventLocalDataSource.saveEventToDB(event)
    }

    override suspend fun getEventsFromDB(): List<Event>? {
        return getEventsFromROOM()
    }

    override suspend fun deleteEvent(event: Event) {
        return eventLocalDataSource.deleteEvent(event)
    }

    override suspend fun getSpotifyData(
        authorization: String,
        artistName: String
    ): List<SpotifyData> {
        var spotifyData = arrayListOf<SpotifyData>()
        try {
            val response = spotifyRemoteDataSource.getSpotifyData(authorization, artistName)
            Log.d(
                "Spotify API Response",
                "Response Code : ${response.code()}, message : ${response.message()}"
            )
            val body = response.body()

            if (body != null) {
                spotifyData.add(body)
                Log.d(
                    "Spotify API response",
                    "First Artist name :${spotifyData[0].artists.items[0].name}"
                )
            }
        } catch (e: java.lang.Exception) {
            Log.e("Spotify API Response", "Error : ${e.message}")
        }

        Log.d("Spotify API RESPONSE", "You have gotten ${spotifyData.size}")

        return spotifyData
    }

    override fun getAccessToken(
        authorization: String,
        getToken: String
    ): Call<AccessTokenResponse> = spotifyRemoteDataSource.getAccessToken(authorization, getToken)


    private suspend fun getEventsFromAPI(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): List<Event> {
        var eventsList: List<Event> = emptyList()

        try {
            val response = eventRemoteDataSource.getEvent(keyword, distance, category, location)
            Log.d(
                "API Response",
                "Response code: ${response.code()}, message: ${response.message()}"
            )
            val body = response.body()

            if (body != null) {
                eventsList = body._embedded.events
                Log.d("API Response", "First event name: ${eventsList[0].name}")
            }
        } catch (e: Exception) {
            Log.e("API Response", "Error: ${e.message}")
        }

        Log.d("API Response", "You have gotten ${eventsList.size} events")
        return eventsList
    }

    private suspend fun getEventsFromROOM(): List<Event> {
        lateinit var eventsList: List<Event>

        try {
            eventsList = eventLocalDataSource.getEventsFromDB()
        } catch (_: java.lang.Exception) {
        }

        if (eventsList.isEmpty()) {
            return eventsList
        }
        return eventsList
    }

    override suspend fun getEventById(eventId: String): List<Event>? {
        var matchingEvent: List<Event>? = null
        try {

            matchingEvent = eventLocalDataSource.getEventById(eventId)
            println("Got ${matchingEvent?.size}")
        } catch (_: java.lang.Exception) {
        }

        println("You found ${matchingEvent?.size} matching events")
        return matchingEvent
    }

    private suspend fun getEventsFromCache(): List<Event>? {
        lateinit var eventsList: List<Event>

        try {
            eventsList = eventCacheDataSource.getEventsFromCache()
        } catch (_: java.lang.Exception) {
        }

        if (eventsList.isNotEmpty()) {
            return eventsList
        } else {
            eventsList = getEventsFromROOM()
            eventCacheDataSource.saveEventsToCache(eventsList)
        }
        return eventsList
    }

    private suspend fun saveEventToRoom(event: Event) {
        return eventLocalDataSource.saveEventToDB(event)
    }

}