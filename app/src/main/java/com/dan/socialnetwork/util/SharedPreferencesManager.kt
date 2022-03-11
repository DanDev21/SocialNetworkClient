package com.dan.socialnetwork.util

import android.content.SharedPreferences

class SharedPreferencesManager(
    private val sharedPreferences: SharedPreferences
) {

    fun safeAuthenticationToken(token: String) =
        sharedPreferences.edit()
            .putString(SharedPrefKey.JWT, token)
            .apply()

    fun getAuthenticationToken() =
        sharedPreferences.getString(SharedPrefKey.JWT, "")
}