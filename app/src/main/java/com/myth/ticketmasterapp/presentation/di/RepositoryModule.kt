package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.EventRepositoryImplementation
import com.myth.ticketmasterapp.data.datasource.EventCacheDataSource
import com.myth.ticketmasterapp.data.datasource.EventLocalDataSource
import com.myth.ticketmasterapp.data.datasource.EventRemoteDataSource
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource
import com.myth.ticketmasterapp.domain.repository.EventRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesEventRepository(
        eventRemoteDataSource: EventRemoteDataSource,
        eventLocalDataSource: EventLocalDataSource,
        eventCacheDataSource: EventCacheDataSource,
        spotifyRemoteDataSource: SpotifyRemoteDataSource
    ): EventRepository {
        return EventRepositoryImplementation(
            eventRemoteDataSource,
            eventLocalDataSource,
            eventCacheDataSource,
            spotifyRemoteDataSource
        )
    }
}