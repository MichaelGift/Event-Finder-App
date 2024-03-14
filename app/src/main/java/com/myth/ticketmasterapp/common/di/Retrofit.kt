package com.myth.ticketmasterapp.common.di

import com.myth.ticketmasterapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object Retrofit {
    @Provides
    fun provideTicketMasterRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    fun providesSpotifyRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.SPOTIFY_BASE_URL)
            .build()
    }

    @Provides
    fun providesSpotifyAuthRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.SPOTIFY_TOKEN_ACCESS_URL)
            .build()
    }
}