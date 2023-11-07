package io.astronout.core.data.source.local.room

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class StringTypeConverter {

    private val moshi = Moshi.Builder().build()
    private val stringType = Types.newParameterizedType(List::class.java, String::class.java)
    private val stringAdapter = moshi.adapter<List<String>>(stringType)

    @TypeConverter
    fun stringToStrings(string: String): List<String> {
        return stringAdapter.fromJson(string).orEmpty()
    }

    @TypeConverter
    fun stringsToString(data: List<String>): String {
        return stringAdapter.toJson(data)
    }

}