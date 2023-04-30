package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.datasource.EventCacheDataSource
import com.myth.ticketmasterapp.data.datasourceimplementation.EventCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesEventCacheDataSource(): EventCacheDataSource {
        return EventCacheDataSourceImplementation()
    }
}