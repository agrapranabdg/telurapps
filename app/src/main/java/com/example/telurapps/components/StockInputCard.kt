package com.example.telurapps.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockInputCard(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    onUpdate: () -> Unit
) {
    Card(
        modifier = Modifier.width(170.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFCE7C8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title)
            Spacer(Modifier.height(10.dp))
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .width(100.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFFFF1D5)
                )
            )
            Button(
                onClick = onUpdate,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDA853))
            ) {
                Text("Update")
            }
        }
    }
}