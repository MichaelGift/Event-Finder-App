package com.myth.ticketmasterapp.data.datasrcimpl

import com.myth.ticketmasterapp.data.datasrc.CacheEvents
import com.myth.ticketmasterapp.data.eventmodels.Event

class CacheEventsImplementation : CacheEvents {

    private var eventsList = ArrayList<Event>()
    override suspend fun getEventsFromCache(): List<Event> {
        return eventsList
    }

    override suspend fun saveEventsToCache(events: List<Event>) {
        eventsList.clear()
        eventsList = ArrayList(events)
    }

}