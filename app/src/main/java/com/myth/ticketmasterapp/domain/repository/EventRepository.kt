package com.myth.ticketmasterapp.domain.repository

import com.myth.ticketmasterapp.data.eventdatamodels.Event

interface EventRepository {

    suspend fun getEvent(): List<Event>?
    suspend fun saveEvent(event: Event)
    suspend fun getEventsFromDB(): List<Event>?
    suspend fun deleteEvent(event: Event)
    suspend fun getEventById(eventId: String)
    suspend fun getSpotifyData(artistName: String)
}