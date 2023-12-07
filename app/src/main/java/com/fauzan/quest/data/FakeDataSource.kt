package com.fauzan.quest.data

import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.data.model.TaskPriority
import com.fauzan.quest.utils.TimeUtils

private val ONE_SECOND = 1000L
private val ONE_MINUTE = ONE_SECOND * 60
private val ONE_HOUR = ONE_MINUTE * 60

object FakeDataSource {
    val tasks = mutableListOf(
        OneTimeTask(
            id = 1,
            title = "Learn Kotlin",
            description = "Learn Kotlin from Udacity",
            priority = TaskPriority.HIGH,
            dueDateMillis = System.currentTimeMillis() + TimeUtils.ONE_MINUTE
        ),
        RepeatingTask(
            id = 2,
            title = "Do the laundry",
            description = "Do the laundry and hang the clothes",
            priority = TaskPriority.MEDIUM,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 10,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 3,
            title = "Buy groceries",
            description = "Buy groceries at the nearest supermarket",
            priority = TaskPriority.LOW,
            dueDateMillis = System.currentTimeMillis() + ONE_HOUR,
        ),
        RepeatingTask(
            id = 4,
            title = "Do the dishes",
            description = "Do the dishes and clean the kitchen",
            priority = TaskPriority.MEDIUM,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 20,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 5,
            title = "Read a book",
            description = "Read a book about Kotlin",
            priority = TaskPriority.HIGH,
            dueDateMillis = System.currentTimeMillis() + ONE_MINUTE * 2
        ),
        RepeatingTask(
            id = 6,
            title = "Water the plants",
            description = "Water the plants and give them fertilizer",
            priority = TaskPriority.LOW,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 30,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 7,
            title = "Clean the house",
            description = "Clean the house and throw away the trash",
            priority = TaskPriority.MEDIUM,
            dueDateMillis = System.currentTimeMillis() + ONE_HOUR * 2
        ),
    )
}