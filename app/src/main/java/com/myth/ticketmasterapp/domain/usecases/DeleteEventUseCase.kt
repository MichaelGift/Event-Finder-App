package com.myth.ticketmasterapp.domain.usecases

import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.domain.repository.EventRepository

class DeleteEventUseCase(private var eventRepository: EventRepository){
    suspend fun execute(event: Event) = eventRepository.deleteEvent(event)
}