package com.fauzan.quest.scheduler

import com.fauzan.quest.data.model.RepeatingTask

interface AlarmScheduler {
    fun schedule(task: RepeatingTask)
    fun cancel(task: RepeatingTask)
}