package com.example.data.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {
    @TypeConverter
    fun fromArrayList(list: ArrayList<String>?): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toArrayList(json: String?): ArrayList<String> {
        val type = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(json, type) ?: arrayListOf()
    }
}