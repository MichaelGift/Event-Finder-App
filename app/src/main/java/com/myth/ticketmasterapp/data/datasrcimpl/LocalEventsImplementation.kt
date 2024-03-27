package com.myth.ticketmasterapp.data.datasrcimpl

import com.myth.ticketmasterapp.data.datasrc.LocalEvents
import com.myth.ticketmasterapp.data.db.EventDao
import com.myth.ticketmasterapp.data.eventmodels.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalEventsImplementation(
    private val eventDao: EventDao
) : LocalEvents {
    override suspend fun getEventsFromDB(): List<Event> {
        return eventDao.getEvents()
    }

    override suspend fun saveEventToDB(events: Event) {
        CoroutineScope(Dispatchers.IO).launch {
            eventDao.saveEvents(events)
        }
    }

    override suspend fun deleteEvent(event: Event) {
        CoroutineScope(Dispatchers.IO).launch {
            eventDao.deleteEvent(event)
        }
    }

    override suspend fun getEventById(eventId: String) : List<Event>? = eventDao.getEventById(eventId)
}