package com.fauzan.quest.scheduler

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.fauzan.quest.data.model.RepeatingTask

class AndroidAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)
    @SuppressLint("MissingPermission")
    override fun schedule(task: RepeatingTask) {

        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(AlarmReceiver.EXTRA_TASK_ID, task.getId())
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC,
            task.getRepeatAtMillis(),
            PendingIntent.getBroadcast(
                context,
                task.getId(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

    override fun cancel(task: RepeatingTask) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                task.getId(),
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }
}