package com.myth.ticketmasterapp.domain.usecases

import androidx.lifecycle.LiveData
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.domain.repository.EventRepository

class GetEventUseCase(private var eventRepository: EventRepository) {
    suspend fun execute(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ): List<Event>? = eventRepository.getEvent(keyword, distance, category, location)

    suspend fun getEventsFromDB(): List<Event>? = eventRepository.getEventsFromDB()

    suspend fun getEventById(eventId: String): List<Event>? =
        eventRepository.getEventById(eventId)
}