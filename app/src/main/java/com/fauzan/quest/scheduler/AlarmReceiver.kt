package com.fauzan.quest.scheduler

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.fauzan.quest.R
import com.fauzan.quest.data.model.BaseTask
import com.fauzan.quest.di.Injection
import com.fauzan.quest.ui.MainActivity

class AlarmReceiver: BroadcastReceiver() {

    private val repository = Injection.provideRepository()

    override fun onReceive(context: Context, intent: Intent?) {
        val taskId = intent?.getIntExtra(EXTRA_TASK_ID, -1) ?: -1
        if (taskId == -1) return

        repository.getTask(taskId)?.let { task ->
            notify(context, task)
        }
    }

    private fun notify(context: Context, task: BaseTask) {
        val pendingIntent = PendingIntent.getActivity(
            context,
            task.getId(),
            Intent(context, MainActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Quest")
            .setContentText(task.getTitle())
            .setSmallIcon(R.drawable.logo)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        ))
        notificationManager.notify(task.getId(), notification)
    }

    companion object {
        const val EXTRA_TASK_ID = "extra_task_id"
        const val NOTIFICATION_CHANNEL_ID = "channel_01"
        const val NOTIFICATION_CHANNEL_NAME = "Quest"
    }
}