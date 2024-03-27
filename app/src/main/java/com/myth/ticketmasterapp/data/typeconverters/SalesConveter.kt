package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.myth.ticketmasterapp.data.eventmodels.Sales

class SalesConveter {
    @TypeConverter
    fun fromSales(value: Sales): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toSales(value: String): Sales {
        return Gson().fromJson(value, Sales::class.java)
    }
}