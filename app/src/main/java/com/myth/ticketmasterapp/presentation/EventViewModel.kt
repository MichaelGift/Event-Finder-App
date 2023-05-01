package com.myth.ticketmasterapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.myth.ticketmasterapp.data.eventdatamodels.Event
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase
import kotlinx.coroutines.launch
import retrofit2.Call

class EventViewModel(
    private val getEventUseCase: GetEventUseCase,
    private val saveEventUseCase: SaveEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getSpotifyDataUseCase: GetSpotifyDataUseCase
) : ViewModel() {

    lateinit var accessToken: String

    lateinit var chosenEvent: Event

    fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ) = liveData {
        val eventList = getEventUseCase.execute(keyword, distance, category, location)
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

    fun getSpotifyData(authorization: String, artistName: String) = liveData {
        val spotifyData = getSpotifyDataUseCase.execute(authorization, artistName)
        emit(spotifyData)
    }

    fun getAccessToken(authorization: String, grantType: String): Call<AccessTokenResponse> =
        getSpotifyDataUseCase.getAccessToken(authorization, grantType)

}