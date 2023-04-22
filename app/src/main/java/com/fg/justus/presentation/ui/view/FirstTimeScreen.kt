package com.fg.justus.presentation.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fg.justus.presentation.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "FirstTime = ${viewModel.isFirstTime()}", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
//                navController.navigate(Screen.SecondScreen.route)
                      viewModel.changeFirstTime()
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Change value")
        }
    }
}