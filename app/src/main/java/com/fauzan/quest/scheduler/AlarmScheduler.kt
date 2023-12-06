package com.fauzan.quest.scheduler

import com.fauzan.quest.data.model.OneTimeTask

interface AlarmScheduler {
    fun schedule(task: OneTimeTask)
    fun cancel(task: OneTimeTask)
}