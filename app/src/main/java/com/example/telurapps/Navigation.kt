package com.example.telurapps

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.telurapps.screens.MenuUtamaScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            MenuUtamaScreen(navController)
        }
//        composable(route = "StokTelur") {
//            StokTelurScreen(navController)
//        }
//        composable(route = "StokAyam") {
//            StokAyamScreen(navController)
//        }
//        composable(route = "StokPakan") {
//            StokPakanScreen(navController)
//        }
//        composable(route = "Penjualan") {
//            PenjualanScreen(navController)
//        }
//        composable(route = "Aktivitas") {
//            AktivitasScreen(navController)
//        }
//        composable(route = "SignIn") {
//            SignInScreen(navController)
//        }
//        composable(route = "LogIn") {
//            LogInScreen(navController)
//        }
    }
}