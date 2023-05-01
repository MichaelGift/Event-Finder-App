package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule(
    private val baseUrl: String,
    private val spotifyURl: String,
    private val spotifyAuthUrl: String
) {
    @Singleton
    @Provides
    @Named("ticketMasterRetrofit")
    fun providesRetrofit(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    @Named("spotifyRetrofit")
    fun providesSpotifyRetrofit(): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(spotifyURl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    @Named("spotifyAuthRetrofit")
    fun providesSpotifyAuthRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(spotifyAuthUrl).build()
    }

    @Singleton
    @Provides
    fun providesTicketMasterService(@Named("ticketMasterRetrofit") retrofit: Retrofit): TicketMasterService {
        return retrofit.create(TicketMasterService::class.java)
    }

    @Singleton
    @Provides
    fun providesSpotifyService(@Named("spotifyRetrofit") retrofit: Retrofit): SpotifyService {
        return retrofit.create(SpotifyService::class.java)
    }

    @Singleton
    @Provides
    fun providesSpotifyAuthService(@Named("spotifyAuthRetrofit") retrofit: Retrofit): SpotifyAuthService {
        return retrofit.create(SpotifyAuthService::class.java)
    }
}