package io.astronout.core.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.convertDateTo(
    desireFormat: ConverterDate,
    originalFormat: ConverterDate = ConverterDate.SQL_DATE
): String {
    return if (this.isNotEmpty()) {
        val dateFormat = SimpleDateFormat(originalFormat.formatter, Locale.getDefault())
        val date = dateFormat.parse(this) ?: Date()
        dateFormat.applyPattern(desireFormat.formatter)
        dateFormat.format(date)
    } else {
        "-"
    }
}

fun String.toDate(format: ConverterDate = ConverterDate.SQL_DATE): Date? {
    return SimpleDateFormat(format.formatter, Locale.getDefault()).parse(this)
}

fun Date.toString(format: ConverterDate = ConverterDate.SQL_DATE): String {
    return try {
        SimpleDateFormat(
            format.formatter, Locale.getDefault()
        ).format(this)
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

fun getDateRange(range: Range, isPast: Boolean): String {
    val format = DateTimeFormatter.ofPattern(ConverterDate.SQL_DATE.formatter)
    val today = LocalDate.now()
    return if (isPast) {
        val prev = when (range) {
            Range.YEAR -> today.minusYears(1)
            Range.MONTH -> today.minusMonths(1)
            Range.DATE -> today.minusDays(1)
        }
        "${prev.format(format)},${today.format(format)}"
    } else {
        val future = when (range) {
            Range.YEAR -> today.plusYears(1)
            Range.MONTH -> today.plusMonths(1)
            Range.DATE -> today.plusDays(1)
        }
        "${today.format(format)},${future.format(format)}"
    }
}

fun getLastMonthDate(): Date {
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.MONTH, -1)
    return calendar.time
}

enum class Range {
    YEAR, MONTH, DATE
}

