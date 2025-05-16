package com.example.telurapps.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomizedTextField(
    nama: String,
    value: String,
    onValueChange: (String) -> Unit,
    readOnly: Boolean
) {

    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(nama, modifier = Modifier.width(150.dp), fontSize = 20.sp)
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1F),
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp)
        )
    }
}