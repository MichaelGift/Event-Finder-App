package com.myth.ticketmasterapp.presentation.di

import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun eventSubComponent(): EventSubComponent.Factory
}