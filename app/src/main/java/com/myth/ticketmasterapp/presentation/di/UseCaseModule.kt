package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.domain.repository.EventRepository
import com.myth.ticketmasterapp.domain.usecases.DeleteEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetEventUseCase
import com.myth.ticketmasterapp.domain.usecases.GetSpotifyDataUseCase
import com.myth.ticketmasterapp.domain.usecases.SaveEventUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun providesGetEventUseCase(eventRepository: EventRepository): GetEventUseCase {
        return GetEventUseCase(eventRepository)
    }

    @Provides
    fun providesSaveEventUseCase(eventRepository: EventRepository): SaveEventUseCase{
        return SaveEventUseCase(eventRepository)
    }

    @Provides
    fun providesDeleteEventUseCase(eventRepository: EventRepository):DeleteEventUseCase{
        return DeleteEventUseCase(eventRepository)
    }
    @Provides
    fun providesGetSpotifyDataUseCase(eventRepository: EventRepository):GetSpotifyDataUseCase{
        return GetSpotifyDataUseCase(eventRepository)
    }
}