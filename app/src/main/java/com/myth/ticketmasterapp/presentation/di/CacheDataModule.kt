package com.myth.ticketmasterapp.presentation.di

import com.myth.ticketmasterapp.data.datasrc.CacheEvents
import com.myth.ticketmasterapp.data.datasrcimpl.CacheEventsImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesEventCacheDataSource(): CacheEvents {
        return CacheEventsImplementation()
    }
}