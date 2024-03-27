package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.myth.ticketmasterapp.data.eventmodels.ImageXX

class ImageXXConverter {

    @TypeConverter
    fun fromImageXXList(value: List<ImageXX>): String {
        val gson = Gson()
        val jsonArray = JsonArray()
        value.forEach { ImageXX ->
            val jsonObject = gson.toJsonTree(ImageXX).asJsonObject
            jsonArray.add(jsonObject)
        }

        return jsonArray.toString()
    }

    @TypeConverter
    fun toImageXXList(value: String): List<ImageXX> {
        val gson = Gson()
        val jsonArray = JsonParser().parse(value).asJsonArray
        val imageList = mutableListOf<ImageXX>()
        jsonArray.forEach { jsonObject ->
            imageList.add(gson.fromJson(jsonObject, ImageXX::class.java))
        }
        return imageList
    }
}