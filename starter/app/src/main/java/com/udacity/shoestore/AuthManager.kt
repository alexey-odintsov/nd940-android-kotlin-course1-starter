package com.udacity.shoestore

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import timber.log.Timber

class AuthManager(private val application: Application) {

    fun isAuthorized(): Boolean {
        val prefs: SharedPreferences = application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(PREFS_AUTHORISED, false)
    }

    fun logout() {
        saveAuth(false)
    }

    fun saveAuth(authorized: Boolean) {
        Timber.d("authorized: $authorized")
        val prefs: SharedPreferences = application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(PREFS_AUTHORISED, authorized).apply()

    }

    companion object {
        const val PREFS_NAME = "prefs"
        const val PREFS_AUTHORISED = "authorized"

        private var instance: AuthManager? = null

        fun getInstance(application: Application): AuthManager {
            if (instance == null) {
                instance = AuthManager(application)
            }
            return instance as AuthManager
        }
    }
}