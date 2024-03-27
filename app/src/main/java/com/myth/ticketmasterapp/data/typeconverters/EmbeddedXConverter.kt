package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventmodels.VenueData

class EmbeddedXConverter {
    @TypeConverter
    fun fromEmbeddedX(value: VenueData): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toEmbeddedX(value: String): VenueData {
        return Gson().fromJson(value, VenueData::class.java)
    }
}