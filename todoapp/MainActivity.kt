package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.uix.viewmodel.AnasayfaViewModel
import com.example.todoapp.uix.viewmodel.ToDoDetayViewModel
import com.example.todoapp.uix.viewmodel.ToDoKayitViewModel
import com.example.todoapp.uix.views.SayfaGecisleri
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val anasayfaViewModel : AnasayfaViewModel by viewModels()
    val toDoKayitViewModel : ToDoKayitViewModel by viewModels()
    val toDoDetayViewModel : ToDoDetayViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                SayfaGecisleri(
                    anasayfaViewModel = anasayfaViewModel,
                    toDoKayitViewModel = toDoKayitViewModel,
                    toDoDetayViewModel = toDoDetayViewModel
                )
            }
        }
    }
}
