package com.myth.ticketmasterapp.domain.usecases

import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.domain.repository.EventRepository
import javax.inject.Inject

class DeleteEventUseCase @Inject constructor(
    private var eventRepository: EventRepository
){
    suspend fun execute(event: Event) = eventRepository.deleteEvent(event)
}