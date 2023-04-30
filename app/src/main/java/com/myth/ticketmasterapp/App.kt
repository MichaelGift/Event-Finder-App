package com.myth.ticketmasterapp

import android.app.Application
import com.myth.ticketmasterapp.presentation.di.*
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    @Inject
    @Named("ticketMasterRetrofit")
    lateinit var ticketMasterRetrofit: Retrofit

    @Inject
    @Named("spotifyRetrofit")
    lateinit var spotifyRetrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL, BuildConfig.SPOTIFY_BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY, BuildConfig.AUTHORIZATION))
            .build()
    }

    override fun createEventSubComponent(): EventSubComponent {
        return appComponent.eventSubComponent().create()
    }
}