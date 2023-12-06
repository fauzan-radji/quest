package com.fauzan.quest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.fauzan.quest.R

sealed class Navigation(
    val route: String,
    val titleId: Int,
    val icon: ImageVector,
) {
    object Home : Navigation(
        route = "home",
        titleId = R.string.home,
        icon = Icons.Default.Home,
    )

    object AddTask: Navigation(
        route = "addTask",
        titleId = R.string.add_task,
        icon = Icons.Default.AddCircle,
    )

    companion object {
        val bottomBarItems = listOf(
            Home,
            AddTask,
        )
    }
}
