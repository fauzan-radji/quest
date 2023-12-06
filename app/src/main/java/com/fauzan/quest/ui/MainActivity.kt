package com.fauzan.quest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.scheduler.AndroidAlarmScheduler
import com.fauzan.quest.ui.theme.QuestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scheduler = AndroidAlarmScheduler(this)
        val scheduleAlarm: (OneTimeTask) -> Unit = { task ->
             scheduler.schedule(task)
        }
        setContent {
            QuestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp(scheduleAlarm = scheduleAlarm)
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainPreview() {
//    QuestTheme {
//        MainApp()
//    }
//}