package com.fauzan.quest.ui.screen.addtask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fauzan.quest.R
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.TaskPriority
import com.fauzan.quest.di.Injection
import com.fauzan.quest.ui.ViewModelFactory
import com.fauzan.quest.ui.component.DatePicker
import com.fauzan.quest.ui.component.Dropdown
import com.fauzan.quest.ui.component.TextField
import com.fauzan.quest.ui.component.TimePicker
import com.fauzan.quest.utils.TimeUtils
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun AddTaskScreen(
    scheduleAlarm: (OneTimeTask) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: AddTaskViewModel = viewModel(
        factory = ViewModelFactory(repository = Injection.provideRepository())
    )
) {
    var title by remember { viewModel.title }
    var description by remember { viewModel.description }
    var priority by remember { viewModel.priority }
    var dueDate by remember { viewModel.dueDate }
    var dueTime by remember { viewModel.dueTime }
    AddTaskContent(
        title = title,
        description = description,
        priority = priority,
        dueDate = dueDate,
        dueTime = dueTime,
        onTitleChange = { title = it },
        onDescriptionChange = { description = it },
        onPriorityChange = { priority = it },
        onDueDateChange = { dueDate = it },
        onDueTimeChange = { dueTime = it },
        onSave = {
            viewModel.addTask(scheduleAlarm = scheduleAlarm)
            navController.navigateUp()
        },
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun AddTaskContent(
    title: String,
    description: String,
    priority: TaskPriority?,
    dueDate: LocalDate,
    dueTime: LocalTime,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onPriorityChange: (TaskPriority) -> Unit,
    onDueDateChange: (LocalDate) -> Unit,
    onDueTimeChange: (LocalTime) -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    val formattedDate by remember { derivedStateOf { TimeUtils.formatDate(dueDate) }}
    val formattedTime by remember { derivedStateOf { TimeUtils.formatTime(dueTime) }}
    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()

    val spacer = 16.dp

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = onTitleChange,
            label = stringResource(R.string.title),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(spacer))
        TextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = stringResource(R.string.description),
            modifier = Modifier.fillMaxWidth(),
            lines = 4
        )
        Spacer(modifier = Modifier.height(spacer))
        Dropdown(
            label = "Priority",
            value = priority?.value ?: "",
            expanded = dropdownExpanded,
            onExpandedChange = { dropdownExpanded = it },
            modifier = Modifier.fillMaxWidth()
        ) {
            for (taskPriority in TaskPriority.values()) {
                DropdownMenuItem(
                    text = { Text(text = taskPriority.value) },
                    onClick = {
                        onPriorityChange(taskPriority)
                        dropdownExpanded = false
                    },
                    colors = MenuDefaults.itemColors(
                        textColor = taskPriority.color
                    ),
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                )
            }
        }
        Spacer(modifier = Modifier.height(spacer))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { dateDialogState.show() },
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date",
                    modifier = Modifier.fillMaxSize()
                )
            }
            TextField(
                value = formattedDate,
                onValueChange = onTitleChange,
                label = "Due Date",
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(spacer))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { timeDialogState.show() },
                modifier = Modifier.size(56.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Time",
                    modifier = Modifier.fillMaxSize()
                )
            }
            TextField(
                value = formattedTime,
                onValueChange = onTitleChange,
                label = "Due Time",
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(spacer))
        Button(
            onClick = onSave,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save Task")
        }
    }

    DatePicker(
        state = dateDialogState,
        onValueChange = onDueDateChange
    )

    TimePicker(
        state = timeDialogState,
        onValueChange = onDueTimeChange
    )
}

//@Preview(showBackground = true)
//@Composable
//fun AddTaskPreview() {
//    QuestTheme {
//        AddTaskScreen()
//    }
//}