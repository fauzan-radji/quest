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
}
