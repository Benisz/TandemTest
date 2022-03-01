package com.kapmacs.tandemtest.util

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromStringArray(strings: List<String>?): String {
        return strings?.joinToString(",") ?: ""
    }

    @TypeConverter
    fun toArray(concatenatedString: String): List<String> {
        return concatenatedString.split(",")
    }
}
