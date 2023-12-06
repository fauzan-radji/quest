package com.fauzan.quest.data

import com.fauzan.quest.data.model.BaseTask

class Repository {
    private val tasks = mutableListOf<BaseTask>()

    init {
        if (tasks.isEmpty()) {
            tasks.addAll(FakeDataSource.tasks)
        }
    }

    fun getTasks() = tasks

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