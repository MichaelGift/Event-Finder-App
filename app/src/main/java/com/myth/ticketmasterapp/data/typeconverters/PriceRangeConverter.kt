package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.myth.ticketmasterapp.data.eventmodels.PriceRange

class PriceRangeConverter {


    @TypeConverter
    fun fromPriceRangeList(value: List<PriceRange>): String {
        val gson = Gson()
        val jsonArray = JsonArray()
        value.forEach { PriceRange ->
            val jsonObject = gson.toJsonTree(PriceRange).asJsonObject
            jsonArray.add(jsonObject)
        }

        return jsonArray.toString()
    }

    @TypeConverter
    fun toPriceRangeList(value: String): List<PriceRange> {
        val gson = Gson()
        val jsonArray = JsonParser().parse(value).asJsonArray
        val priceRangeList = mutableListOf<PriceRange>()
        jsonArray.forEach { jsonObject ->
            priceRangeList.add(gson.fromJson(jsonObject, PriceRange::class.java))
        }
        return priceRangeList
    }
}