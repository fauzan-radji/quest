package com.fauzan.quest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.data.model.TaskPriority
import com.fauzan.quest.ui.theme.QuestTheme
import com.fauzan.quest.utils.TimeUtils

@Composable
fun TaskCard(
    task: OneTimeTask,
    onClick: (OneTimeTask) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.clickable { onClick(task) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = task.getTitle(),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Row {
                Text(
                    text = "One Time Task",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = task.getPriority().value,
                    style = MaterialTheme.typography.bodySmall,
                    color = task.getPriority().color,
                    modifier = Modifier
                        .background(
                            color = task.getPriority().color.copy(alpha = 0.1f),
                            shape = MaterialTheme.shapes.extraSmall
                        )
                        .padding(horizontal = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task.getDescription(),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Due on ${task.getDueDate()}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun TaskCard(
    task: RepeatingTask,
    onClick: (RepeatingTask) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.clickable { onClick(task) }) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = task.getTitle(),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Row {
                Text(
                    text = "Repeating Task",
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = task.getPriority().value,
                    style = MaterialTheme.typography.bodySmall,
                    color = task.getPriority().color,
                    modifier = Modifier
                        .background(
                            color = task.getPriority().color.copy(alpha = 0.1f),
                            shape = MaterialTheme.shapes.extraSmall
                        )
                        .padding(horizontal = 2.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = task.getDescription(),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Ring every ${task.getRepeatAt()}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskCardPreview() {
    QuestTheme {
        Column {
            TaskCard(
                task = OneTimeTask(
                    id = 1,
                    title = "Learn Kotlin",
                    description = "Learn Kotlin from Udacity",
                    priority = TaskPriority.HIGH,
                    dueDateMillis = System.currentTimeMillis() + TimeUtils.ONE_SECOND * 5
                ),
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            TaskCard(
                task = RepeatingTask(
                    id = 2,
                    title = "Do the laundry",
                    description = "Do the laundry and hang the clothes",
                    priority = TaskPriority.MEDIUM,
                    repeatAtMillis = System.currentTimeMillis() + TimeUtils.ONE_SECOND * 10
                ),
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}