package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventdatamodels.EmbeddedX

class EmbeddedXConverter {
    @TypeConverter
    fun fromEmbeddedX(value: EmbeddedX): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toEmbeddedX(value: String): EmbeddedX {
        return Gson().fromJson(value, EmbeddedX::class.java)
    }
}