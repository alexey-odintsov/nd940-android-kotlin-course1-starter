package com.udacity.shoestore

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import timber.log.Timber

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    private val _loginLiveData = MutableLiveData<Boolean>()
    val loginLiveData: LiveData<Boolean>
        get() = _loginLiveData

    init {
        _loginLiveData.value = loadAuth()
    }

    private fun loadAuth(): Boolean {
        val prefs: SharedPreferences = getApplication<Application>().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(PREFS_AUTHORISED, false)
    }

    private fun saveAuth(authorized: Boolean) {
        Timber.d("authorized: $authorized")
        val prefs: SharedPreferences = getApplication<Application>().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(PREFS_AUTHORISED, authorized).apply()

    }

    /**
     * Simplified version - checks only login and password length
     */
    fun login(login: String, password: String): Boolean {
        val valid = login.length > 5 && password.length > 5
        if (valid) {
            saveAuth(valid)
            _loginLiveData.value = true
        }
        return valid
    }

    fun logout() {
        saveAuth(false)
        _loginLiveData.value = false
    }

    companion object {
        const val PREFS_NAME = "prefs"
        const val PREFS_AUTHORISED = "authorized"
    }
}