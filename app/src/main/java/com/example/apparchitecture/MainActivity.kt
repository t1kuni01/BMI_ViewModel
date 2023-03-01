package com.example.apparchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apparchitecture.ui.theme.AppArchitectureTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppArchitectureTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BMICalculatorScreen()
                }
            }
        }
    }
}


class BMICalculatorViewModel : ViewModel() {
    // Height in meters
    val height = mutableStateOf(1.7f)

    // Weight in kilograms
    val weight = mutableStateOf(70f)

    fun calculateBMI(): Float {
        return weight.value / (height.value * height.value)
    }
}
@Composable
fun BMICalculatorScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val viewModel: BMICalculatorViewModel = viewModel()

        TextField(
            value = viewModel.height.value.toString(),
            onValueChange = { value -> viewModel.height.value = value.toFloatOrNull() ?: 0f },
            label = { Text(text = "Height (m)") }
        )

        TextField(
            value = viewModel.weight.value.toString(),
            onValueChange = { value -> viewModel.weight.value = value.toFloatOrNull() ?: 0f },
            label = { Text(text = "Weight (kg)") }
        )

        Text(
            text = "BMI: ${viewModel.calculateBMI()}",
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Button(onClick = {}) {
            Text(text = "Calculate BMI")
        }
    }
}
