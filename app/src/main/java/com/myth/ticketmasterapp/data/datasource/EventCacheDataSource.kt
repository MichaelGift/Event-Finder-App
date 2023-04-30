package com.myth.ticketmasterapp.data.datasource

import com.myth.ticketmasterapp.data.eventdatamodels.Event

interface EventCacheDataSource {
    suspend fun getEventsFromCache(): List<Event>
    suspend fun saveEventsToCache(events: List<Event>)
}