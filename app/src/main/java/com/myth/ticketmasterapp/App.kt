package com.myth.ticketmasterapp

import android.app.Application
import com.myth.ticketmasterapp.presentation.di.*

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL, BuildConfig.SPOTIFY_BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY, BuildConfig.AUTHORIZATION)).build()
    }

    override fun createEventSubComponent(): EventSubComponent {
        return appComponent.eventSubComponent().create()
    }
}