package com.myth.ticketmasterapp.common.di

import com.myth.ticketmasterapp.BuildConfig
import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Retrofit {
    @Singleton
    @Provides
    @Named("ticketMaster")
    fun provideTicketMasterRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    @Named("spotify")
    fun providesSpotifyRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.SPOTIFY_BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    @Named("spotifyAuth")
    fun providesSpotifyAuthRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.SPOTIFY_TOKEN_ACCESS_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesTicketMasterService(@Named("ticketMaster") retrofit: Retrofit): TicketMasterService {
        return retrofit.create(TicketMasterService::class.java)
    }

    @Singleton
    @Provides
    fun providesSpotifyService(@Named("spotify") retrofit: Retrofit): SpotifyService {
        return retrofit.create(SpotifyService::class.java)
    }

    @Singleton
    @Provides
    fun providesSpotifyAuthService(@Named("spotifyAuth") retrofit: Retrofit): SpotifyAuthService {
        return retrofit.create(SpotifyAuthService::class.java)
    }
}