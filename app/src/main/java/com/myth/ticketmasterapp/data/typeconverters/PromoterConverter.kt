package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.myth.ticketmasterapp.data.eventmodels.Promoter

class PromoterConverter {
    @TypeConverter
    fun fromPromoterList(value: List<Promoter>): String {
        val gson = Gson()
        val jsonArray = JsonArray()
        value.forEach { Promoter ->
            val jsonObject = gson.toJsonTree(Promoter).asJsonObject
            jsonArray.add(jsonObject)
        }

        return jsonArray.toString()
    }

    @TypeConverter
    fun toPriceRangeList(value: String): List<Promoter> {
        val gson = Gson()
        val jsonArray = JsonParser().parse(value).asJsonArray
        val promotersList = mutableListOf<Promoter>()
        jsonArray.forEach { jsonObject ->
            promotersList.add(gson.fromJson(jsonObject, Promoter::class.java))
        }
        return promotersList
    }
}