package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding

class ShoeListingFragment  : Fragment() {

    lateinit var adapter: ShoeAdapter
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeListingFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.shoe_listing_fragment, container, false
        )

        adapter = ShoeAdapter(emptyList())
        binding.shoeList.adapter = adapter

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        viewModel.listLiveData.observe(viewLifecycleOwner, { list ->
            adapter.setData(list)
        })

        return binding.root
    }
}