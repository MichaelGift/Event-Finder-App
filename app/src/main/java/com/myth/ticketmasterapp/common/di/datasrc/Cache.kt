package com.myth.ticketmasterapp.common.di.datasrc

import com.myth.ticketmasterapp.data.datasrc.CacheEvents
import com.myth.ticketmasterapp.data.datasrcimpl.CacheEventsImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Cache {
    @Singleton
    @Provides
    fun providesCacheEvents(): CacheEvents {
        return CacheEventsImplementation()
    }
}