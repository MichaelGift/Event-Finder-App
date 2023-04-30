package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String, private val spotifyBaseUrl: String) {

    @Provides
    @Named("ticketMasterRetrofit")
    fun provideTicketMasterRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Named("spotifyRetrofit")
    fun provideSpotifyRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(spotifyBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideTicketMasterService(@Named("ticketMasterRetrofit") retrofit: Retrofit): TicketMasterService {
        return retrofit.create(TicketMasterService::class.java)
    }

    @Provides
    fun provideSpotifyService(@Named("spotifyRetrofit") retrofit: Retrofit): SpotifyService {
        return retrofit.create(SpotifyService::class.java)
    }
}
