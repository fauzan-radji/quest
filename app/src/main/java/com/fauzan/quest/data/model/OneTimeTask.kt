package com.fauzan.quest.data.model

import com.fauzan.quest.utils.TimeUtils

class OneTimeTask(
    id: Int,
    title: String,
    description: String,
    priority: TaskPriority,
    private var dueDateMillis: Long
) : BaseTask(
    id,
    title,
    description,
    priority,
) {

    fun getDueDateMillis() = dueDateMillis
    fun getDueDate() = TimeUtils.formatDateTime(dueDateMillis)
    override fun calculateUrgency(): Int {
        val currentDateMillis = System.currentTimeMillis()

        val dueDateWeight = 0.7
        val priorityWeight = 0.3

        val millisecondsInDay = 24 * 60 * 60 * 1000
        val timeDifferenceMillis = dueDateMillis - currentDateMillis
        val timeDifferenceDays = timeDifferenceMillis / millisecondsInDay.toDouble()

        val dueDateUrgency = if (timeDifferenceMillis > 0) {
            1.0 - timeDifferenceDays
        } else {
            0.0
        }

        val priorityUrgency = getPriority().weight / 10.0

        val combinedUrgency = (dueDateUrgency * dueDateWeight) + (priorityUrgency * priorityWeight)

        val normalizedUrgency = (combinedUrgency * 10).toInt()

        return normalizedUrgency.coerceIn(1, 10)
    }
}
