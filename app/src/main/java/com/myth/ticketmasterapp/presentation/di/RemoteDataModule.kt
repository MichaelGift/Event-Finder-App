package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import com.myth.ticketmasterapp.data.datasrc.RemoteEvents
import com.myth.ticketmasterapp.data.datasrc.RemoteSpotify
import com.myth.ticketmasterapp.data.datasrcimpl.RemoteEventsImplementation
import com.myth.ticketmasterapp.data.datasrcimpl.RemoteSpotifyImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun providesEventRemoteDataSource(ticketMasterService: TicketMasterService): RemoteEvents {
        return RemoteEventsImplementation(ticketMasterService, apiKey)
    }

    @Singleton
    @Provides
    fun providesSpotifyRemoteDataSource(
        spotifyService: SpotifyService,
        spotifyAuthService: SpotifyAuthService
    ): RemoteSpotify {
        return RemoteSpotifyImplementation(
            spotifyService,
            spotifyAuthService
        )
    }
}