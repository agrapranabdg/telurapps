package com.example.telurapps.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun DisplayCurrentDate() {
    val currentDate = Date()
    val formatter = SimpleDateFormat("EEEE, dd-MM-yyyy", Locale.getDefault())
    val formattedDate = formatter.format(currentDate)
    Text(text = " $formattedDate", fontSize = 20.sp, color = Black)
}