package com.myth.ticketmasterapp.common.di

import com.myth.ticketmasterapp.data.EventRepositoryImplementation
import com.myth.ticketmasterapp.domain.repository.EventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class Bindings {

    @Binds
    abstract fun provideRepository(
        eventRepositoryImplementation: EventRepositoryImplementation
    ): EventRepository
}