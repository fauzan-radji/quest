package com.fauzan.quest.utils

import java.text.SimpleDateFormat
import java.util.Date

object TimeUtils {
    fun formatDateTime(dateTimeMillis: Long): String {
        val dateTimeFormat = SimpleDateFormat.getDateTimeInstance(
            SimpleDateFormat.MEDIUM,
            SimpleDateFormat.SHORT
        )
        return dateTimeFormat.format(Date(dateTimeMillis))
    }

    fun formatTime(timeMillis: Long): String {
        val timeFormat = SimpleDateFormat.getTimeInstance(SimpleDateFormat.SHORT)
        return timeFormat.format(Date(timeMillis))
    }

    const val ONE_SECOND = 1000L
}