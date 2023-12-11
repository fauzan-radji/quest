package com.fauzan.quest.ui.screen.addtask

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fauzan.quest.data.Repository
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.data.model.TaskPriority
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneOffset

class AddTaskViewModel(private val repository: Repository) : ViewModel() {
    var title = mutableStateOf("")
    var description = mutableStateOf("")
    var priority = mutableStateOf<TaskPriority?>(null)
    var dueDate = mutableStateOf(LocalDate.now())
    var dueTime = mutableStateOf(LocalTime.now())
    var intervalMillis = mutableStateOf(0L)

    fun addOneTimeTask(scheduleAlarm: (OneTimeTask) -> Unit) {
        val localDateTime = LocalDateTime.of(dueDate.value, dueTime.value)
        val oneTimeTask: OneTimeTask = repository.addTask(
            title = title.value,
            description = description.value,
            priority = priority.value ?: TaskPriority.LOW,
            dueDateMillis = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli()
        )
        scheduleAlarm(oneTimeTask)
    }

    fun addRepeatingTask(scheduleAlarm: (RepeatingTask) -> Unit) {
        val localDateTime = LocalDateTime.of(dueDate.value, dueTime.value)
        val repeatingTask: RepeatingTask = repository.addTask(
            title = title.value,
            description = description.value,
            priority = priority.value ?: TaskPriority.LOW,
            triggerAtMillis = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli(),
            intervalMillis = intervalMillis.value
        )
        scheduleAlarm(repeatingTask)
    }
}