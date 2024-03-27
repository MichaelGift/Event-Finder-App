package com.myth.ticketmasterapp.presentation

import androidx.lifecycle.*
import com.myth.ticketmasterapp.data.eventmodels.Event
import com.myth.ticketmasterapp.data.spotifydatamodels.AccessTokenResponse
import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getEventUseCase: GetEventUseCase,
    private val saveEventUseCase: SaveEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getSpotifyDataUseCase: GetSpotifyDataUseCase
) : ViewModel() {

    lateinit var accessToken: String

    lateinit var chosenEvent: Event

    /*lateinit var homeFragmentAdapter: HomeFragmentAdapter*/

    var _listEvents = MutableLiveData<List<Event>?>()
    val listEvents: LiveData<List<Event>?> = MediatorLiveData<List<Event>?>().apply {
        addSource(_listEvents) { value = it }
    }


    fun getEvent(
        keyword: String,
        distance: String,
        category: String,
        location: String
    ) = liveData {
        val eventList = getEventUseCase.execute(keyword, distance, category, location)
        _listEvents.value = eventList/*
        println("You have the following number of events ${listEvents.value?.size}")*/
        emit(eventList)
    }

    fun saveEventToFavorite(event: Event) = liveData {
        val savedEvent = saveEventUseCase.execute(event)
        emit(savedEvent)
    }

    fun deleteEventFromFavorite(event: Event) = liveData {
        val deletedEvent = deleteEventUseCase.execute(event)
        emit(deletedEvent)
    }

    fun getEventId(eventId: String) = liveData {
        val matchingEvents = getEventUseCase.getEventById(eventId)
        emit(matchingEvents)
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