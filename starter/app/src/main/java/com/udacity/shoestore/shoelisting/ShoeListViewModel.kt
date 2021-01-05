package com.udacity.shoestore.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.App
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _listLiveData = MutableLiveData<List<Shoe>>()
    val listLiveData: LiveData<List<Shoe>>
        get() = _listLiveData

    init {
        _listLiveData.value = App.SHOE_LIST
    }
}