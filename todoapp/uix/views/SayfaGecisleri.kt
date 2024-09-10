package com.example.todoapp.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.uix.viewmodel.AnasayfaViewModel
import com.example.todoapp.uix.viewmodel.ToDoDetayViewModel
import com.example.todoapp.uix.viewmodel.ToDoKayitViewModel
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(anasayfaViewModel: AnasayfaViewModel,toDoKayitViewModel: ToDoKayitViewModel,toDoDetayViewModel: ToDoDetayViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController,anasayfaViewModel)
        }

        composable("toDoKayitSayfa") {
            ToDoKayitSayfa(toDoKayitViewModel)
        }

        composable("toDoDetaySayfa/{icerik}",
            arguments = listOf(
                navArgument("icerik"){ type = NavType.StringType }
            )
        )
        {
            val json = it.arguments?.getString("icerik")
            val nesne = Gson().fromJson(json,ToDo::class.java)
            ToDoDetaySayfa(nesne,toDoDetayViewModel)
        }
    }
}