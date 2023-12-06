package com.fauzan.quest

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fauzan.quest.navigation.Navigation
import com.fauzan.quest.ui.component.BottomBar

@Composable
fun MainApp(
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
            Navigation.items.forEach { navigation ->
                composable(navigation.route) {
                    navigation.screen()
                }
            }
        }
    }
}