package com.fauzan.quest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.fauzan.quest.R

sealed class Screen(
    val route: String,
    val title: Int,
    val icon: ImageVector,
) {
    object Home : Screen(
        route = "home",
        title = R.string.home,
        icon = Icons.Default.Home,
    )
}
