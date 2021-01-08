package com.udacity.shoestore.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: InstructionsFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.instructions_fragment, container, false
        )

        binding.controller = this
        return binding.root
    }

    fun navigateToListing() {
        findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())
    }
}