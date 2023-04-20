package com.fg.justus.domain.repository

interface PreferencesRepository {
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
    fun setBoolean(key: String, value: Boolean)
}