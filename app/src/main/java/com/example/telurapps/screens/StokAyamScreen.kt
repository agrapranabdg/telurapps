package com.example.telurapps.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
//import com.example.telurapps.components.SelectDate
import com.example.telurapps.components.StockDisplayCard
import com.example.telurapps.components.StockInputCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StokAyamScreen(navController: NavController) {
    var stokAyam by remember { mutableStateOf(0) }
    var ayamMasukValue by remember { mutableStateOf("") }
    var ayamKeluarValue by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Stok Ayam")
                },
                navigationIcon = {
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF1D5))
            .paddingFromBaseline(top = 10.dp)) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(Modifier.height(100.dp))
                StockDisplayCard(
                    title = "Stok Ayam Hari Ini",
                    stock = stokAyam,
                    unit = "ekor"
                )
//                SelectDate()
                Spacer(Modifier.height(10.dp))
                Row {
                    StockInputCard("Ayam Masuk",
                        value = ayamMasukValue,
                        onValueChange = {str -> ayamMasukValue = str},
                        onUpdate = {
                            stokAyam = stokAyam + ayamMasukValue.toInt()
                            ayamMasukValue = ""}
                    )
                    Spacer(Modifier.width(20.dp))
                    StockInputCard("Ayam Keluar",
                        value = ayamKeluarValue,
                        onValueChange = {str -> ayamKeluarValue = str},
                        onUpdate = {
                            if (ayamKeluarValue.toInt() <= stokAyam) {
                                stokAyam = stokAyam - ayamKeluarValue.toInt()
                                ayamKeluarValue = ""
                            }
                        }
                    )
                }
            }
        }
    }
}