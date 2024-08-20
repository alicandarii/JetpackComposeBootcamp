package com.example.odevnav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable("sayfa1"){
            Sayfa1(navController = navController)
        }
        composable("sayfa2"){
            Sayfa2(navController = navController)
        }
        composable("sayfa3"){
            Sayfa3(navController = navController)
        }
        composable("sayfa4"){
            Sayfa4(navController = navController)
        }
    }

}