package com.example.telurapps.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StockDisplayCard(
    title: String,
    stock: Int,
    unit: String
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFBEA)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )  {
            Spacer(Modifier.height(20.dp))
            Text(text = title, fontSize = 30.sp)
            DisplayCurrentDate()
            Spacer(modifier = Modifier.height(15.dp))
            Text("$stock $unit", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(40.dp))
            Text("Update $title", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}