package com.udacity.shoestore.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    fun addShoe(name: String, company: String, size: Double, description: String) {
        SHOE_LIST.add(Shoe(name, size, company, description, listOf()))
        _listLiveData.value = SHOE_LIST
    }

    private val _listLiveData = MutableLiveData<List<Shoe>>()
    val listLiveData: LiveData<List<Shoe>>
        get() = _listLiveData

    init {
        _listLiveData.value = SHOE_LIST
    }

    companion object {
        val SHOE_LIST = mutableListOf(
                Shoe("Boots", 44.0, "Ecco", "Good boots", listOf()),
                Shoe("Sandals", 36.0, "Ralf", "Casual sandals", listOf()),
                Shoe("Crossers", 33.0, "Nike", "Autumn 2020", listOf()),
                Shoe("Big Foot", 50.0, "Nike", "Big size", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 2", 15.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 3", 16.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 4", 17.0, "Reebok", "Good for kids", listOf())
        )
    }
}