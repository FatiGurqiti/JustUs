package com.fg.justus.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.fg.justus.domain.repository.PreferencesRepository

class PreferencesRepositoryImpl (context: Context) : PreferencesRepository {

    companion object {
        const val IS_FIRST_TIME = "is_first_time"
    }
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("justUsDefaults", Context.MODE_PRIVATE)

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    override fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
}