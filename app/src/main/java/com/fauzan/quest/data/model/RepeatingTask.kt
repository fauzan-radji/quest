package com.fauzan.quest.data.model

import com.fauzan.quest.utils.TimeUtils

class RepeatingTask(
    id: Int,
    title: String,
    description: String,
    priority: TaskPriority,
    private var repeatAtMillis: Long,
) : BaseTask(id, title, description, priority) {
    fun getRepeatAtMillis() = repeatAtMillis
    fun getRepeatAt() = TimeUtils.formatTime(repeatAtMillis)
}