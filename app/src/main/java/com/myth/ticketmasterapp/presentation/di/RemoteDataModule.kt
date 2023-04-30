package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import com.myth.ticketmasterapp.data.datasource.EventRemoteDataSource
import com.myth.ticketmasterapp.data.datasource.SpotifyRemoteDataSource
import com.myth.ticketmasterapp.data.datasourceimplementation.EventRemoteDataSourceImplementation
import com.myth.ticketmasterapp.data.datasourceimplementation.SpotifyRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String, private val authorization: String) {
    @Singleton
    @Provides
    fun providesEventRemoteDataSource(ticketMasterService: TicketMasterService): EventRemoteDataSource {
        return EventRemoteDataSourceImplementation(ticketMasterService, apiKey)
    }
    @Singleton
    @Provides
    fun providesSpotifyRemoteDataSource(spotifyService: SpotifyService): SpotifyRemoteDataSource {
        return SpotifyRemoteDataSourceImplementation(spotifyService,authorization)
    }
}