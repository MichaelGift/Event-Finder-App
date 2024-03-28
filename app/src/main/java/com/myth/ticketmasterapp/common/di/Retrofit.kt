package com.myth.ticketmasterapp.common.di

import android.content.Context
import com.myth.ticketmasterapp.BuildConfig
import com.myth.ticketmasterapp.data.api.SpotifyAuthService
import com.myth.ticketmasterapp.data.api.SpotifyService
import com.myth.ticketmasterapp.data.api.TicketMasterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Retrofit {

    @Provides

    fun provideOkHTTPClientCache(context: Context): OkHttpClient {
        val cache = Cache(context.cacheDir, CACHE_SIZE)
        val interceptor = Interceptor { chain ->
            val originalResponse = chain.proceed(chain.request())
            val cacheControl = originalResponse.header("Cache-Control")
            if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-age=0")
            ) {
                originalResponse
            } else {
                val maxAge = 60
                originalResponse.newBuilder().header("Cache-Control", "public, max-age=$maxAge")
                    .build()
            }
        }
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(interceptor)
            .build()
    }

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
    fun providesSpotifyRetrofit(
        cacheClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .client(cacheClient)
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