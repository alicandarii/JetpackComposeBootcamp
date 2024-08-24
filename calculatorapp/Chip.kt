package com.example.calculatorapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Chip(
    text:String,
    onClick : ()-> Unit,
    modifier: Modifier = Modifier,
    backgroundColor : Color = Color(0xFFE0E0E0),
    contentColor : Color = Color.White
) {
    Button(onClick = onClick,
        modifier = modifier
            .padding(4.dp)
            .size(80.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        shape = RoundedCornerShape(50)
         ) {
            Text(text = text, style = MaterialTheme.typography.headlineSmall)
    }
}