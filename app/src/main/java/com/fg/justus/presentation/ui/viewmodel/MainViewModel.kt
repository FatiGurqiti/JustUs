package com.fg.justus.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fg.justus.data.local.preferences.PreferencesRepositoryImpl
import com.fg.justus.domain.repository.PreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            if (!isFirstTime()) {
                // Load stuff
                delay(1.seconds)
            }
            _isLoading.value = false
        }
    }

    fun isFirstTime() = preferencesRepository.getBoolean(PreferencesRepositoryImpl.IS_FIRST_TIME, true)

    fun changeFirstTime() { preferencesRepository.setBoolean(PreferencesRepositoryImpl.IS_FIRST_TIME, false)
    }
}