package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.EventRepositoryImplementation
import com.myth.ticketmasterapp.data.datasrc.CacheEvents
import com.myth.ticketmasterapp.data.datasrc.LocalEvents
import com.myth.ticketmasterapp.data.datasrc.RemoteEvents
import com.myth.ticketmasterapp.data.datasrc.RemoteSpotify
import com.myth.ticketmasterapp.domain.repository.EventRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun providesEventRepository(
        remoteEvents: RemoteEvents,
        localEvents: LocalEvents,
        cacheEvents: CacheEvents,
        remoteSpotify: RemoteSpotify
    ): EventRepository {
        return EventRepositoryImplementation(
            remoteEvents,
            localEvents,
            cacheEvents,
            remoteSpotify
        )
    }
}