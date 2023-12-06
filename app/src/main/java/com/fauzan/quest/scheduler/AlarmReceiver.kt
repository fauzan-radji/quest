package com.fauzan.quest.scheduler

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val taskId = intent?.getIntExtra(EXTRA_TASK_ID, -1) ?: -1
        if (taskId == -1) return
        Log.d("AlarmReceiver", "Task $taskId is due!")
    }

    companion object {
        const val EXTRA_TASK_ID = "extra_task_id"
    }
}