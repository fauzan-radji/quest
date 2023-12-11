package com.fauzan.quest.scheduler

import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask

interface AlarmScheduler {
    fun schedule(task: OneTimeTask)
    fun cancel(task: OneTimeTask)

    fun schedule(task: RepeatingTask)
    fun cancel(task: RepeatingTask)
}