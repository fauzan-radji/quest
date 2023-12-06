package com.fauzan.quest.ui.screen.addtask

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.fauzan.quest.data.Repository
import com.fauzan.quest.data.model.TaskPriority
import java.time.LocalDate
import java.time.LocalTime

class AddTaskViewModel(val repository: Repository) : ViewModel() {
    var title = mutableStateOf("")
    var description = mutableStateOf("")
    var priority = mutableStateOf<TaskPriority?>(null)
    var dueDate = mutableStateOf(LocalDate.now())
    var dueTime = mutableStateOf(LocalTime.now())
}