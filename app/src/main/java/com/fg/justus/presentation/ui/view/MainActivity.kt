package com.fg.justus.presentation.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fg.justus.presentation.ui.theme.JustUsTheme
import com.fg.justus.presentation.ui.theme.blue00
import com.fg.justus.presentation.ui.theme.blue1E
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            installSplashScreen().apply {
                setKeepVisibleCondition {
                    viewModel.isLoading.value
                }
            }
            MainTheme()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainTheme() {
    JustUsTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            GradientBackground()
        }
    }
}

@Composable
fun GradientBackground() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(blue00, blue1E)
                )
            )
    ) {
        Circle()
    }
}

@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .size(size = 200.dp)
    ) {
        drawCircle(
            color = Color.White
        )
    }
}
