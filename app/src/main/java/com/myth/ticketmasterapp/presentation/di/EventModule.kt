package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase
import com.myth.ticketmasterapp.presentation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class EventModule {
    @EventScope
    @Provides
    fun providesEventViewModelFactory(
        getEventUseCase: GetEventUseCase,
        saveEventUseCase: SaveEventUseCase,
        deleteEventUseCase: DeleteEventUseCase,
        getSpotifyDataUseCase: GetSpotifyDataUseCase
    ): ViewModelFactory {
        return ViewModelFactory(getEventUseCase, saveEventUseCase, deleteEventUseCase, getSpotifyDataUseCase)
    }
}