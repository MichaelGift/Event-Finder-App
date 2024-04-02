package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.myth.ticketmasterapp.data.eventmodels.Posters

class ImageXXConverter {

    @TypeConverter
    fun fromImageXXList(value: List<Posters>): String {
        val gson = Gson()
        val jsonArray = JsonArray()
        value.forEach { ImageXX ->
            val jsonObject = gson.toJsonTree(ImageXX).asJsonObject
            jsonArray.add(jsonObject)
        }

        return jsonArray.toString()
    }

    @TypeConverter
    fun toImageXXList(value: String): List<Posters> {
        val gson = Gson()
        val jsonArray = JsonParser().parse(value).asJsonArray
        val imageList = mutableListOf<Posters>()
        jsonArray.forEach { jsonObject ->
            imageList.add(gson.fromJson(jsonObject, Posters::class.java))
        }
        return imageList
    }
}