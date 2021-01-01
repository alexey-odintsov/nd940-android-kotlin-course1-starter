package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        binding.loginButton.setOnClickListener {
            login()
        }
        binding.registerButton.setOnClickListener {
            register()
        }
        return binding.root
    }

    private fun validateLogin(): Boolean {
        val login = binding.loginEdittext.text
        return login.length > 5
    }

    private fun validatePassword(): Boolean {
        val password = binding.passwordEdittext.text
        return password.length > 5
    }

    private fun login() {
        if (!validateLogin()) {
            binding.loginEdittext.error = "Wrong login!"
        } else if (!validatePassword()) {
            binding.passwordEdittext.error = "Wrong password!"
        } else {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
    }

    private fun register() {
        if (!validateLogin()) {
            binding.loginEdittext.error = "Wrong login!"
        } else if (!validatePassword()) {
            binding.passwordEdittext.error = "Wrong password!"
        } else {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
    }
}