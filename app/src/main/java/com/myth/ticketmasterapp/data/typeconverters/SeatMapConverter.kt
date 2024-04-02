package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventmodels.Seatmap

class SeatMapConverter {
    @TypeConverter
    fun fromSeatmap(value: Seatmap): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toSeatmap(value: String): Seatmap {
        return Gson().fromJson(value, Seatmap::class.java)
    }
}