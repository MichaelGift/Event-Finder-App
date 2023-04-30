package com.myth.ticketmasterapp.data.datasourceimplementation

import com.myth.ticketmasterapp.data.datasource.EventCacheDataSource
import com.myth.ticketmasterapp.data.eventdatamodels.Event

class EventCacheDataSourceImplementation : EventCacheDataSource {

    private var eventsList = ArrayList<Event>()
    override suspend fun getEventsFromCache(): List<Event> {
        return eventsList
    }

    override suspend fun saveEventsToCache(events: List<Event>) {
        eventsList.clear()
        eventsList = ArrayList(events)
    }

}