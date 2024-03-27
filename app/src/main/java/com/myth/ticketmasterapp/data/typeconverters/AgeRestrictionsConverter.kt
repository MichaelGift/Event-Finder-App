package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventmodels.AgeRestrictions

class AgeRestrictionsConverter {
    @TypeConverter
    fun fromAgeRestrictions(value: AgeRestrictions): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toAgeRestrictions(value: String): AgeRestrictions {
        return Gson().fromJson(value, AgeRestrictions::class.java)
    }
}