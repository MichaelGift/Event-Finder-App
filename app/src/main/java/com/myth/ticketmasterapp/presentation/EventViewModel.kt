package com.myth.ticketmasterapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase
import kotlinx.coroutines.launch

class EventViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val saveEventUseCase: SaveEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getSpotifyDataUseCase: GetSpotifyDataUseCase
) : ViewModel() {

    lateinit var chosenEvent: Event

    fun getEvent() = liveData {
        val eventList = getEventUseCase.execute()
        emit(eventList)
    }

    fun saveEventToFavorite(event: Event) = viewModelScope.launch {
        saveEventUseCase.execute(event)
    }

    fun deleteEventFromFavorite(event: Event) = viewModelScope.launch {
        deleteEventUseCase.execute(event)
    }

    fun getEventId(eventId: String) = viewModelScope.launch {
        getEventUseCase.getEventById(eventId)
    }

    fun getFavoriteEvents() = liveData {
        val eventsList = getEventUseCase.getEventsFromDB()
        emit(eventsList)
    }
    fun getSpotifyData(artistName: String) =viewModelScope.launch {
        getSpotifyDataUseCase.execute(artistName)
    }
}