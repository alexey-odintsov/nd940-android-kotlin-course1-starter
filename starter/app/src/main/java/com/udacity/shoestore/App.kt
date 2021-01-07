package com.udacity.shoestore

import android.app.Application
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        val SHOE_LIST = mutableListOf<Shoe>(
                Shoe("Boots", 44.0, "Ecco", "Good boots", listOf()),
                Shoe("Sandals", 36.0, "Ralf", "Casual sandals", listOf()),
                Shoe("Crossers", 33.0, "Nike", "Autumn 2020", listOf()),
                Shoe("Big Foot", 50.0, "Nike", "Big size", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 2", 15.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 3", 16.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 4", 17.0, "Reebok", "Good for kids", listOf()),
                Shoe("Boots", 44.0, "Ecco", "Good boots", listOf()),
                Shoe("Sandals", 36.0, "Ralf", "Casual sandals", listOf()),
                Shoe("Crossers", 33.0, "Nike", "Autumn 2020", listOf()),
                Shoe("Big Foot", 50.0, "Nike", "Big size", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 2", 15.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 3", 16.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 4", 17.0, "Reebok", "Good for kids", listOf()),
                Shoe("Boots", 44.0, "Ecco", "Good boots", listOf()),
                Shoe("Sandals", 36.0, "Ralf", "Casual sandals", listOf()),
                Shoe("Crossers", 33.0, "Nike", "Autumn 2020", listOf()),
                Shoe("Big Foot", 50.0, "Nike", "Big size", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 2", 15.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 3", 16.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 4", 17.0, "Reebok", "Good for kids", listOf()),
                Shoe("Boots", 44.0, "Ecco", "Good boots", listOf()),
                Shoe("Sandals", 36.0, "Ralf", "Casual sandals", listOf()),
                Shoe("Crossers", 33.0, "Nike", "Autumn 2020", listOf()),
                Shoe("Big Foot", 50.0, "Nike", "Big size", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie", 14.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 2", 15.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 3", 16.0, "Reebok", "Good for kids", listOf()),
                Shoe("Kiddie 4", 17.0, "Reebok", "Good for kids", listOf()),
        )
    }
}