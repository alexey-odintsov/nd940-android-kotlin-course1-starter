package com.udacity.shoestore.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.udacity.shoestore.AuthManager

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private var authManager: AuthManager = AuthManager.getInstance(application)

    /**
     * Simplified version - checks only login and password length
     */
    fun login(login: String, password: String): Boolean {
        val valid = login.length > 5 && password.length > 5
        if (valid) {
            authManager.saveAuth(valid)
        }
        return valid
    }
}