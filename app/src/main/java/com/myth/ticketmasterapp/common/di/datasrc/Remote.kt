package com.myth.ticketmasterapp.common.di.datasrc

import com.myth.ticketmasterapp.BuildConfig
import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import com.myth.ticketmasterapp.data.datasrc.RemoteEvents
import com.myth.ticketmasterapp.data.datasrc.RemoteSpotify
import com.myth.ticketmasterapp.data.datasrcimpl.RemoteEventsImplementation
import com.myth.ticketmasterapp.data.datasrcimpl.RemoteSpotifyImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Remote {
    @Singleton
    @Provides
    fun provideRemoteEvents(service: TicketMasterService): RemoteEvents {
        return RemoteEventsImplementation(service, BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun providesRemoteSpotify(
        spotify: SpotifyService,
        spotifyAuth: SpotifyAuthService
    ): RemoteSpotify {
        return RemoteSpotifyImplementation(spotify, spotifyAuth)
    }
}