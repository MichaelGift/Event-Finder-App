package com.myth.ticketmasterapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase

class ViewModelFactory(
    private val getEventUseCase: GetEventUseCase,
    private val saveEventUseCase: SaveEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getSpotifyDataUseCase: GetSpotifyDataUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EventViewModel(
            getEventUseCase,
            saveEventUseCase,
            deleteEventUseCase,
            getSpotifyDataUseCase
        ) as T
    }
}