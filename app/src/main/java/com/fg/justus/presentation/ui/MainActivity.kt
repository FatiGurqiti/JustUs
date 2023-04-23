package com.fg.justus.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fg.justus.presentation.ui.navigation.Navigation
import com.fg.justus.presentation.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            installSplashScreen().apply {
//                setKeepVisibleCondition {
//                    viewModel.isLoading.value
//                }
//            }
            Navigation(viewModel)
        }
    }
}