package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.datasource.EventLocalDataSource
import com.myth.ticketmasterapp.data.datasourceimplementation.EventLocalDataSourceImplementation
import com.myth.ticketmasterapp.data.db.EventDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideEventLocalDataSource(eventDao: EventDao): EventLocalDataSource {
        return EventLocalDataSourceImplementation(eventDao)
    }
}