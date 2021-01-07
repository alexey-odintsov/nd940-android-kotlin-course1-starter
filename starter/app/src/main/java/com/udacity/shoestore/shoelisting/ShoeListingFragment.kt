package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding
import com.udacity.shoestore.models.Shoe

class ShoeListingFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val binding: ShoeListingFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.shoe_listing_fragment, container, false
        )

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        viewModel.listLiveData.observe(viewLifecycleOwner, { list ->
            bindShoes(binding.list, list)
        })

        return binding.root
    }

    private fun bindShoes(list: LinearLayout, items: List<Shoe>?) {
        list.removeAllViews()
        items?.forEach { shoe ->
            val shoeBinding = DataBindingUtil.inflate<ShoeItemBinding>(layoutInflater, R.layout.shoe_item, list, false)
            shoeBinding.name.text = shoe.name
            shoeBinding.companyText.text = shoe.company
            shoeBinding.descriptionText.text = shoe.description
            shoeBinding.sizeText.text = String.format("%.2f", shoe.size)
            list.addView(shoeBinding.root)
        }
    }
}