package com.myth.ticketmasterapp.data.datasrc

import com.myth.ticketmasterapp.data.eventdatamodels.Event

interface CacheEvents {
    suspend fun getEventsFromCache(): List<Event>
    suspend fun saveEventsToCache(events: List<Event>)
}