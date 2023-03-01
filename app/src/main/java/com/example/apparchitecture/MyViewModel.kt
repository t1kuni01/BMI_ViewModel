package com.example.apparchitecture

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel  : ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private var height: Float = 0f
        get() {
            return heightInput.toFloatOrNull() ?: 0f
        }

    private var weight: Int = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }

    var bmi: Float = 0.0f
        get() {
            return if (weight > 0  && height > 0) {
                weight / (height * height)
            } else {
                0.0f
            }
        }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    fun changeWeightInput(value: String) {
        weightInput = value
    }
}