package com.fauzan.quest.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fauzan.quest.data.model.OneTimeTask
import com.fauzan.quest.navigation.Navigation
import com.fauzan.quest.ui.component.BottomBar
import com.fauzan.quest.ui.screen.addtask.AddTaskScreen
import com.fauzan.quest.ui.screen.home.HomeScreen

@Composable
fun MainApp(
    scheduleAlarm: (OneTimeTask) -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigation.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Navigation.Home.route) {
                HomeScreen()
            }
            composable(Navigation.AddTask.route) {
                AddTaskScreen(scheduleAlarm = scheduleAlarm)
            }
        }
    }
}