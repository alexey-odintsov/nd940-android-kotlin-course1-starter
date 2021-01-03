package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.App.Companion.SHOE_LIST
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding

class ShoeListingFragment  : Fragment() {

    lateinit var adapter: ShoeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeListingFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_listing_fragment, container, false
        )

        adapter = ShoeAdapter(SHOE_LIST)
        binding.shoeList.adapter = adapter

        return binding.root
    }
}