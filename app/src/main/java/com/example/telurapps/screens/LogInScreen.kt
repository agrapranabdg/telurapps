package com.example.telurapps.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telurapps.components.CustomizedButton
import com.example.telurapps.components.CustomizedTextField

@Composable
fun LogInScreen (navController: NavController) {
    var nomorHPValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFFFF1D5)), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Log In", fontSize = 30.sp, color = Black)
            Spacer(modifier = Modifier.height(40.dp))
            Spacer(Modifier.height(10.dp))
            CustomizedTextField("No Handphone", value = nomorHPValue, onValueChange = { nomorHPValue = it }, true)
            Spacer(Modifier.height(10.dp))
            CustomizedTextField("Kata Sandi", value = passwordValue, onValueChange = { passwordValue = it }, true)
            Spacer(Modifier.height(20.dp))
            CustomizedButton("Log In", Color(0xFFDDA853), icon = Icons.Filled.BorderColor, onClick = {navController.navigate("Home")})
        }
    }
}