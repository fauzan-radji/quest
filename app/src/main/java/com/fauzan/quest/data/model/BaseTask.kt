package com.fauzan.quest.data.model

abstract class BaseTask(
    private var id: Int,
    private var title: String,
    private var description: String,
    private var priority: TaskPriority,
) {

    fun getId() = id
    fun getTitle() = title
    fun getDescription() = description
    fun getPriority() = priority
}