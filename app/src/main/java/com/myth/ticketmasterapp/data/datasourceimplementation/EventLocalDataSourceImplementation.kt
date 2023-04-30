package com.myth.ticketmasterapp.data.datasourceimplementation

import com.myth.ticketmasterapp.data.datasource.EventLocalDataSource
import com.myth.ticketmasterapp.data.db.EventDao
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventLocalDataSourceImplementation(
    private val eventDao: EventDao
) : EventLocalDataSource {
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

    override suspend fun getEventById(eventId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            eventDao.getEventById(eventId)
        }
    }
}