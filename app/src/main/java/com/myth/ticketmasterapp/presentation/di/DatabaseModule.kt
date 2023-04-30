package com.myth.ticketmasterapp.presentation.di

import android.content.Context
import androidx.room.Room
import com.myth.ticketmasterapp.data.db.EventDao
import com.myth.ticketmasterapp.data.db.EventDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideEventDatabase(context: Context): EventDatabase {
        return Room.databaseBuilder(
            context,
            EventDatabase::class.java,
            "ticketmasterclient"
        ).build()
    }

    @Singleton
    @Provides
    fun providesEventDao(eventDatabase: EventDatabase): EventDao {
        return eventDatabase.eventDao()
    }
}