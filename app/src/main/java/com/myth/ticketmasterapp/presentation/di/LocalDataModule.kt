package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.datasrc.LocalEvents
import com.myth.ticketmasterapp.data.datasrcimpl.LocalEventsImplementation
import com.myth.ticketmasterapp.data.db.EventDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideEventLocalDataSource(eventDao: EventDao): LocalEvents {
        return LocalEventsImplementation(eventDao)
    }
}