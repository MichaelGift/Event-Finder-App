package com.myth.ticketmasterapp.domain.usecases

import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.domain.repository.EventRepository

class GetEventUseCase(private var eventRepository: EventRepository) {
    suspend fun execute(): List<Event>? = eventRepository.getEvent()
    suspend fun getEventsFromDB(): List<Event>? = eventRepository.getEventsFromDB()

    suspend fun getEventById(eventId: String) {
        eventRepository.getEventById(eventId)
    }
}