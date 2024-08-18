package com.example.getirclone

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.example.getirclone.ui.theme.Purple40

@Composable
fun Chip(icerik:String){
    Button(onClick = {  },
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple40,
            contentColor = Color.White
        )
    ) {
        Text(text = icerik)
    }
}