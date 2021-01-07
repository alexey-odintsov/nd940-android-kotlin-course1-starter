package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.shoelisting.ShoeListViewModel
import java.lang.Exception

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.shoe_detail_fragment, container, false
        )

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.saveButton.setOnClickListener {
            val name = validateText(binding.nameEdit)
            val company = validateText(binding.companyEdit)
            val size = validateNumber(binding.sizeEdit)
            val description = validateText(binding.descriptionEdit)
            if (name.isNotBlank() && company.isNotBlank() && !size.isNaN() && description.isNotBlank()) {
                viewModel.addShoe(name, company, size, description)
                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    private fun validateNumber(edit: TextInputEditText): Double {
        return try {
            edit.text.toString().toDouble()
        } catch (e: Exception) {
            edit.error = getString(R.string.error_not_a_number)
            Double.NaN
        }
    }

    private fun validateText(edit: TextInputEditText): String {
        val value = edit.text.toString()
        if (value.isBlank()) {
            edit.error = getString(R.string.error_empty_text)
        }
        return value
    }
}