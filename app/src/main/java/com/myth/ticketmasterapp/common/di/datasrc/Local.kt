package com.myth.ticketmasterapp.common.di.datasrc

import com.myth.ticketmasterapp.data.datasrc.LocalEvents
import com.myth.ticketmasterapp.data.datasrcimpl.LocalEventsImplementation
import com.myth.ticketmasterapp.data.db.EventDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Local {

    @Singleton
    @Provides
    fun providesLocalEvents(eventDao: EventDao): LocalEvents{
        return LocalEventsImplementation(eventDao)
    }
}