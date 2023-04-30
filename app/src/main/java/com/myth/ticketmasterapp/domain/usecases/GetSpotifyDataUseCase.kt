package com.myth.ticketmasterapp.domain.usecases

import com.myth.ticketmasterapp.domain.repository.EventRepository

class GetSpotifyDataUseCase(private var eventRepository: EventRepository) {
    suspend fun execute(artist: String){
        eventRepository.getEventById(artist)
    }
}