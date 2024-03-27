package com.myth.ticketmasterapp.data.datasrc

import com.myth.ticketmasterapp.data.eventmodels.Event

interface LocalEvents {

    suspend fun getEventsFromDB(): List<Event>
    suspend fun saveEventToDB(events:Event)
    suspend fun deleteEvent(events: Event)
    suspend fun getEventById(eventId: String): List<Event>?
}