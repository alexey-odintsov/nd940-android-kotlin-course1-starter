package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.shoelisting.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.shoe_detail_fragment, container, false
        )
        binding.controller = this
        binding.shoe = Shoe("", DEFAULT_SIZE, "", "")

        return binding.root
    }

    fun submit() {
        val shoe = binding.shoe!!
        if (validateShoe(shoe)) {
            viewModel.addShoe(shoe)
            findNavController().popBackStack()
        }
    }

    fun cancel() {
        findNavController().popBackStack()
    }

    private fun validateShoe(shoe: Shoe): Boolean {
        if (shoe.name.isBlank()) {
            binding.nameEdit.error = getString(R.string.error_empty_text)
        }

        if (shoe.size.isNaN()) {
            binding.sizeEdit.error = getString(R.string.error_not_a_number)
        }

        if (shoe.company.isBlank()) {
            binding.companyEdit.error = getString(R.string.error_empty_text)
        }

        if (shoe.description.isBlank()) {
            binding.descriptionEdit.error = getString(R.string.error_empty_text)
        }

        return shoe.name.isNotBlank()
                && shoe.company.isNotBlank()
                && !shoe.size.isNaN()
                && shoe.description.isNotBlank()
    }

    companion object {
        const val DEFAULT_SIZE = 20.0
    }
}