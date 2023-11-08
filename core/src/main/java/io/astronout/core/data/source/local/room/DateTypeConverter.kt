package io.astronout.core.data.source.local.room

import androidx.room.TypeConverter
import io.astronout.core.utils.ConverterDate
import io.astronout.core.utils.toDate
import io.astronout.core.utils.toString
import java.util.Date

class DateTypeConverter {

    @TypeConverter
    fun fromDateToString(date: Date?): String? {
        return date?.toString(ConverterDate.SQL_DATE)
    }

    @TypeConverter
    fun fromStringToDate(dateString: String?): Date? {
        return dateString?.toDate()
    }

}