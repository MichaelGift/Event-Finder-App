package com.myth.ticketmasterapp.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [EventSubComponent::class])
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun providesApplicationContext(): Context {
        return context.applicationContext
    }
}