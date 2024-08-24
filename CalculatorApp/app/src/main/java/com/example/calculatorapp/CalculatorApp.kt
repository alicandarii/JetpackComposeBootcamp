package com.example.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculatorApp() {
    var displayText = remember { mutableStateOf("0") }
    var result = remember { mutableStateOf("") }
    var s1 = remember { mutableStateOf("0") }

    fun butonClick(number: String) {
        if (displayText.value == "0"){
            displayText.value = number
        }else {
            displayText.value += number
        }
    }
    fun topla() {
        s1.value = displayText.value
        displayText.value =  "+"
    }
    fun butonEsittir() {
        val result = s1.value.toInt() + displayText.value.toInt()
        displayText.value = result.toString()
        s1.value = "0"
    }
    fun clear() {
        displayText.value = "0"
        s1.value = "0"
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Hesap Makinesi") }) }
    ) {
            paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = displayText.value,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Text(
                text = "",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )

            Row ( modifier =  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(text = "7", onClick = { butonClick("7") })
                Chip(text = "8", onClick = { butonClick("8") })
                Chip(text = "9", onClick = { butonClick("9") })
                Chip(text = "AC", onClick = { clear() }, backgroundColor = Color(0xFFFF7043))
            }
            Row ( modifier =  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(text = "4", onClick = { butonClick("4") })
                Chip(text = "5", onClick = { butonClick("5") })
                Chip(text = "6", onClick = { butonClick("6") })
                Chip(text = "=", onClick = { butonEsittir() }, backgroundColor = Color(0xFFFF7043))

            }
            Row ( modifier =  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(text = "1", onClick = { butonClick("1") })
                Chip(text = "2", onClick = { butonClick("2") })
                Chip(text = "3", onClick = { butonClick("3") })
                Chip(text = "+", onClick = { topla() }, backgroundColor = Color(0xFFFF7043))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(text = "0", onClick = { butonClick("0") })
            }
        }
    }
}