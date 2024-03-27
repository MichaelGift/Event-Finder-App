package com.myth.ticketmasterapp.data.db

import androidx.room.*
import com.myth.ticketmasterapp.data.eventmodels.Event

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEvents(event: Event)

    @Delete
    suspend fun deleteEvent(event: Event)

    @Query("SELECT * FROM events")
    suspend fun getEvents(): List<Event>

    @Query("SELECT * FROM events  WHERE id = :eventId")
    fun getEventById(eventId : String): List<Event>?
}