package com.example.telurapps.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomizedButton(
    judul: String,
    warna: Color = Color(0xFFFCE7C8),
    icon: ImageVector,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .width(300.dp)
            .height(50.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(containerColor = warna),
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = "Icon",
                modifier = Modifier.padding(end = 8.dp),
                tint = Color(0xFF594100)
            )
            Text(
                text = judul,
                fontSize = 20.sp,
                color = Color.Black

            )
        }
    }
}