package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.AuthViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var authViewModel: AuthViewModel
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
            if (authViewModel.login(binding.loginEdittext.text.toString(), binding.passwordEdittext.text.toString())) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                showLoginError()
            }
        }
        binding.registerButton.setOnClickListener {
            if (authViewModel.login(binding.loginEdittext.text.toString(), binding.passwordEdittext.text.toString())) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            } else {
                showLoginError()
            }
        }

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        authViewModel.loginLiveData.observe(viewLifecycleOwner, { authorized ->
            if (authorized) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListingFragment())
            }
        })
        return binding.root
    }

    private fun showLoginError() {
        binding.loginEdittext.error = "Login and password length should be at least 5 characters!"
    }

}