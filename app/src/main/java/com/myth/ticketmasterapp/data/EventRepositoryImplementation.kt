package com.myth.ticketmasterapp.data

import android.util.Log
import com.myth.ticketmasterapp.data.datasource.EventCacheDataSource
import com.myth.ticketmasterapp.data.datasource.EventLocalDataSource
import com.myth.ticketmasterapp.data.datasource.EventRemoteDataSource
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.domain.repository.EventRepository

class EventRepositoryImplementation(
    private val eventRemoteDataSource: EventRemoteDataSource,
    private val eventLocalDataSource: EventLocalDataSource,
    private val eventCacheDataSource: EventCacheDataSource,
    private val spotifyRemoteDataSource: SpotifyRemoteDataSource
) : EventRepository {
    override suspend fun getEvent(): List<Event>? {
        return getEventsFromAPI()
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

    override suspend fun getEventById(eventId: String) {
        return eventLocalDataSource.getEventById(eventId)
    }

    override suspend fun getSpotifyData(artistName: String) {
        return spotifyRemoteDataSource.getSpotifyData(artistName)
    }

    private suspend fun getEventsFromAPI(): List<Event> {
        var eventsList: List<Event> = emptyList()

        try {
            val response = eventRemoteDataSource.getEvent()
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