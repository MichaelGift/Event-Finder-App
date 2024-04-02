package com.myth.ticketmasterapp.data.db

import androidx.room.*
import com.myth.ticketmasterapp.data.eventmodels.Event

interface EventDao {

    suspend fun saveEvents(event: Event)

    suspend fun deleteEvent(event: Event)

    suspend fun getEvents(): List<Event>

    fun getEventById(eventId : String): List<Event>?
}