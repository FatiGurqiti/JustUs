package com.fg.justus.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fg.justus.presentation.ui.view.FirstTime
import com.fg.justus.presentation.ui.view.Main
import com.fg.justus.presentation.ui.viewmodel.MainViewModel

@Composable
fun Navigation(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val destination =
        if (viewModel.isFirstTime()) Screen.MainScreen.route else Screen.SecondScreen.route
    NavHost(navController = navController, startDestination = destination, builder = {

        if (viewModel.isFirstTime()) {
            composable(route = Screen.MainScreen.route) {
                FirstTime(navController, viewModel).FirstTimeScreen()
            }
        }

        composable(
            route = Screen.SecondScreen.route
        ) {
            Main(viewModel).MainScreen()
        }
    })
}