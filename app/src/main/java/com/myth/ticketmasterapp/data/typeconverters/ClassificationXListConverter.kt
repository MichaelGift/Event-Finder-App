package com.myth.ticketmasterapp.data.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import com.myth.ticketmasterapp.data.eventmodels.ClassificationX

class ClassificationXListConverter {
    @TypeConverter
    fun fromClassificationXList(value: List<ClassificationX>): String {
        val gson = Gson()
        val jsonArray = JsonArray()
        value.forEach { classificationX ->
            val jsonObject = gson.toJsonTree(classificationX).asJsonObject
            jsonArray.add(jsonObject)
        }

        return jsonArray.toString()
    }

    @TypeConverter
    fun toClassificationXList(value: String): List<ClassificationX> {
        val gson = Gson()
        val jsonArray = JsonParser().parse(value).asJsonArray
        val classificationList = mutableListOf<ClassificationX>()
        jsonArray.forEach { jsonObject ->
            classificationList.add(gson.fromJson(jsonObject, ClassificationX::class.java))
        }
        return classificationList
    }
}