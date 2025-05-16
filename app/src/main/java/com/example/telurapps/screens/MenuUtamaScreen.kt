package com.example.telurapps.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telurapps.components.CustomizedButton

@Composable
fun MenuUtamaScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFF1D5)), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Menu Utama", fontSize = 30.sp, color = Black)
            Spacer(modifier = Modifier.height(60.dp))
            CustomizedButton("Stok Telur", icon = Icons.Filled.Scale, onClick = {navController.navigate("StokTelur")})
            Spacer(modifier = Modifier.height(15.dp))
            CustomizedButton("Stok Ayam", Color(0xFFDDA853), icon = Icons.Filled.Home, onClick = {navController.navigate("StokAyam")})
            Spacer(modifier = Modifier.height(15.dp))
            CustomizedButton("Stok Pakan", icon = Icons.Filled.BubbleChart, onClick = {navController.navigate("StokPakan")})
            Spacer(modifier = Modifier.height(15.dp))
            CustomizedButton("Penjualan", Color(0xFFDDA853), icon = Icons.Filled.ShoppingCart, onClick = {navController.navigate("Penjualan")})
            Spacer(modifier = Modifier.height(15.dp))
            CustomizedButton("Aktivitas", icon = Icons.Filled.Person, onClick = {navController.navigate("Aktivitas")})
        }
    }
}