package com.udacity.shoestore

import androidx.databinding.InverseMethod


object SizeConverter {
    @JvmStatic
    @InverseMethod("convertDoubleToString")
    fun convertStringToDouble(value: String): Double {
        return try {
            value.toDouble()
        } catch (e: NumberFormatException) {
            Double.NaN
        }
    }

    @JvmStatic
    fun convertDoubleToString(value: Double): String? {
        return value.toString()
    }
}