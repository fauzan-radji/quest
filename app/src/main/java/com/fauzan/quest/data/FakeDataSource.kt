package com.fauzan.quest.data

import com.fauzan.quest.data.model.BaseTask
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.data.model.RepeatingTask
import com.fauzan.quest.data.model.TaskPriority

private val ONE_SECOND = 1000L
private val ONE_MINUTE = ONE_SECOND * 60
private val ONE_HOUR = ONE_MINUTE * 60

object FakeDataSource {
    val tasks = mutableListOf<BaseTask>(
        OneTimeTask(
            id = 1,
            title = "Learn Kotlin",
            description = "Learn Kotlin from Udacity",
            priority = TaskPriority.HIGH,
            dueDateMillis = System.currentTimeMillis() + ONE_MINUTE
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
        RepeatingTask(
            id = 8,
            title = "Do the laundry",
            description = "Do the laundry and hang the clothes",
            priority = TaskPriority.MEDIUM,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 40,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 9,
            title = "Buy groceries",
            description = "Buy groceries at the nearest supermarket",
            priority = TaskPriority.LOW,
            dueDateMillis = System.currentTimeMillis() + ONE_MINUTE * 3
        ),
        RepeatingTask(
            id = 10,
            title = "Do the dishes",
            description = "Do the dishes and clean the kitchen",
            priority = TaskPriority.MEDIUM,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 50,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 11,
            title = "Read a book",
            description = "Read a book about Kotlin",
            priority = TaskPriority.HIGH,
            dueDateMillis = System.currentTimeMillis() + ONE_HOUR * 3
        ),
        RepeatingTask(
            id = 12,
            title = "Water the plants",
            description = "Water the plants and give them fertilizer",
            priority = TaskPriority.LOW,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 60,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 13,
            title = "Clean the house",
            description = "Clean the house and throw away the trash",
            priority = TaskPriority.MEDIUM,
            dueDateMillis = System.currentTimeMillis() + ONE_MINUTE * 4
        ),
        RepeatingTask(
            id = 14,
            title = "Do the laundry",
            description = "Do the laundry and hang the clothes",
            priority = TaskPriority.MEDIUM,
            triggerAtMillis = System.currentTimeMillis() + ONE_SECOND * 70,
            intervalMillis = ONE_HOUR
        ),
        OneTimeTask(
            id = 15,
            title = "Buy groceries",
            description = "Buy groceries at the nearest supermarket",
            priority = TaskPriority.LOW,
            dueDateMillis = System.currentTimeMillis() + ONE_HOUR * 4
        ),
    )
}