package com.fg.justus.presentation.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fg.justus.presentation.ui.viewmodel.MainViewModel

@Composable
fun SecondScreen(viewModel: MainViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Hello from second screen", color = Color.White)
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                viewModel.changeFirstTime()
            },
        ) {
            Text(text = "change First time")
        }
    }
}