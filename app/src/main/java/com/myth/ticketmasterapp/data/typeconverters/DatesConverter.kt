package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventmodels.Dates

class DatesConverter {
    @TypeConverter
    fun fromDates(value: Dates): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toDates(value: String): Dates {
        return Gson().fromJson(value, Dates::class.java)
    }
}