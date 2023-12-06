package com.fauzan.quest.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

object TimeUtils {
    fun formatDateTime(dateTimeMillis: Long): String {
        val dateTimeFormat = SimpleDateFormat.getDateTimeInstance(
            SimpleDateFormat.MEDIUM,
            SimpleDateFormat.SHORT
        )
        return dateTimeFormat.format(Date(dateTimeMillis))
    }

    fun formatDate(dateMillis: Long): String {
        val dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.MEDIUM)
        return dateFormat.format(Date(dateMillis))
    }

    fun formatTime(timeMillis: Long): String {
        val timeFormat = SimpleDateFormat.getTimeInstance(SimpleDateFormat.SHORT)
        return timeFormat.format(Date(timeMillis))
    }

    fun formatDate(date: LocalDate): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy")
        return date.format(dateTimeFormatter)
    }

    fun formatTime(time: LocalTime): String {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm")
        return time.format(dateTimeFormatter)
    }

    const val ONE_SECOND = 1000L
    const val ONE_MINUTE = ONE_SECOND * 60
    const val ONE_HOUR = ONE_MINUTE * 60
}