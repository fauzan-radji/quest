package com.fauzan.quest.data.model

import com.fauzan.quest.utils.TimeUtils

class RepeatingTask(
    id: Int,
    title: String,
    description: String,
    priority: TaskPriority,
    private var triggerAtMillis: Long,
    private var intervalMillis: Long
) : BaseTask(id, title, description, priority) {
    fun getTriggerAtMillis() = triggerAtMillis
    fun getIntervalMillis() = intervalMillis


    fun getTriggerAt() = TimeUtils.formatTime(triggerAtMillis)
    fun getInterval() = TimeUtils.formatTime(intervalMillis)
    override fun calculateUrgency(): Int {
        return 0
    }
}