package com.fauzan.quest.data

import com.fauzan.quest.data.model.BaseTask
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.data.model.TaskPriority

class Repository {
    private val tasks = mutableListOf<BaseTask>()

    init {
        if (tasks.isEmpty()) {
            tasks.addAll(FakeDataSource.tasks)
        }
    }

    fun getTasks() = tasks

    fun getTask(id: Int) = tasks.find { it.getId() == id }

    fun addTask(
        title: String,
        description: String,
        priority: TaskPriority,
        dueDateMillis: Long
    ): OneTimeTask {
        val id = tasks.size + 1
        val task = OneTimeTask(
            id = id,
            title = title,
            description = description,
            priority = priority,
            dueDateMillis = dueDateMillis
        )
        tasks.add(task)
        return task
    }

    fun addTask(
        title: String,
        description: String,
        priority: TaskPriority,
        triggerAtMillis: Long,
        intervalMillis: Long
    ): RepeatingTask {
        val id = tasks.size + 1
        val task = RepeatingTask(
            id = id,
            title = title,
            description = description,
            priority = priority,
            triggerAtMillis = triggerAtMillis,
            intervalMillis = intervalMillis
        )
        tasks.add(task)
        return task
    }

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(): Repository =
            instance ?: synchronized(this) {
                Repository().apply {
                    instance = this
                }
            }
    }
}