package com.myth.ticketmasterapp.common.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myth.ticketmasterapp.data.db.EventDao
import com.myth.ticketmasterapp.data.db.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Database {

    @Singleton
    @Provides
    fun providesLocalDatabase(context: Context)
        = Room.databaseBuilder(
            context, EventDatabase::class.java, DB_NAME
        ).build()


    @Singleton
    @Provides
    fun providesEventDao(eventDatabase: EventDatabase): EventDao {
        return eventDatabase.eventDao()
    }
}