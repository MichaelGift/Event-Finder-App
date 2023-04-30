package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String, private val spotifyURl: String) {
    @Singleton
    @Provides
    @Named("ticketMasterRetrofit")
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl).build()
    }

    @Singleton
    @Provides
    @Named("spotifyRetrofit")
    fun providesSpotifyRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(spotifyURl).build()
    }


    @Singleton
    @Provides
    fun providesTicketMasterService(@Named("ticketMasterRetrofit")retrofit: Retrofit): TicketMasterService {
        return retrofit.create(TicketMasterService::class.java)
    }

    @Singleton
    @Provides
    fun providesSpotifyService( @Named("spotifyRetrofit")retrofit: Retrofit): SpotifyService{
        return retrofit.create()
    }
}