package com.myth.ticketmasterapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myth.ticketmasterapp.data.typeconverters.*

@Database(
    entities = [com.myth.ticketmasterapp.data.eventmodels.Event::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ClassificationXListConverter::class,
    DatesConverter::class,
    EmbeddedXConverter::class,
    ImageXXConverter::class,
    PriceRangeConverter::class,
    PromoterConverter::class,
    SalesConveter::class,
    SeatMapConverter::class,
)
abstract class EventDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}