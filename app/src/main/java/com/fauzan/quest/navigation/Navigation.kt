package com.fauzan.quest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.fauzan.quest.R
import com.fauzan.quest.ui.screen.AddTaskScreen
import com.fauzan.quest.ui.screen.HomeScreen

sealed class Navigation(
    val route: String,
    val titleId: Int,
    val icon: ImageVector,
    val screen: @Composable () -> Unit,
) {
    object Home : Navigation(
        route = "home",
        titleId = R.string.home,
        icon = Icons.Default.Home,
        screen = { HomeScreen() },
    )

    object AddTask: Navigation(
        route = "addTask",
        titleId = R.string.add_task,
        icon = Icons.Default.AddCircle,
        screen = { AddTaskScreen() }
    )

    companion object {
        val items = listOf(
            Home,
            AddTask,
        )

        val bottomBarItems = listOf(
            Home,
            AddTask,
        )
    }
}
