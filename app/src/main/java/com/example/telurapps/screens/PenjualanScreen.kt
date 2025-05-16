package com.example.telurapps.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.telurapps.components.CustomizedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenjualanScreen(navController: NavController) {
    val pilihanTelur = listOf(
        "Telur Bagus Bakul",
        "Telur Ecer",
        "Telur Reject")
    var expanded by remember { mutableStateOf(false) }
    var jenisTelur by remember { mutableStateOf(pilihanTelur[0]) }
    var tanggalValue by remember { mutableStateOf("") }
    var jumlahTelurValue by remember { mutableStateOf("") }
    var hargaDOValue by remember { mutableStateOf("") }
    var minusDOValue by remember { mutableStateOf("") }
    var namaPembeliValue by remember { mutableStateOf("") }
    var hargaKesepakatanValue = remember(hargaDOValue, minusDOValue) {
        val hargaDO = hargaDOValue.toDoubleOrNull() ?: 0.0
        val minus = minusDOValue.toDoubleOrNull() ?: 0.0
        (hargaDO - minus).toString()
    }

    var totalHargaValue = remember(hargaKesepakatanValue, jumlahTelurValue) {
        val hargaKesepakatan = hargaKesepakatanValue.toDoubleOrNull() ?: 0.0
        val jumlahTelur = jumlahTelurValue.toDoubleOrNull() ?: 0.0
        (hargaKesepakatan * jumlahTelur).toString()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Penjualan Telur")
                },
                navigationIcon = {
                    IconButton(onClick = {navController.navigateUp()}) {
                        Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = null)
                    }
                }
            )
        }
    )
    { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFF1D5)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box {
                    Column {
                        Text(" Update Penjualan", fontSize = 20.sp)
                        OutlinedTextField(
                            value = jenisTelur,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Pilihan Telur") },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                    modifier = Modifier.clickable { expanded = true }
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            pilihanTelur.forEach { activity ->
                                DropdownMenuItem(text = { Text(activity) },
                                    onClick = {
                                        jenisTelur = activity
                                        expanded = false
                                    })
                            }
                        }
                    }

                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
//                    PilihTanggal()
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Jumlah Telur (kg)", value = jumlahTelurValue, onValueChange = {str -> jumlahTelurValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Harga DO", value = hargaDOValue, onValueChange = {str -> hargaDOValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Minus di Bawah DO", value = minusDOValue, onValueChange = {str -> minusDOValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Harga Kesepakatan", value = hargaKesepakatanValue, onValueChange = {str -> hargaKesepakatanValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Total Harga", value = totalHargaValue, onValueChange = {str -> totalHargaValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    CustomizedTextField("Nama Pembeli", value = namaPembeliValue, onValueChange = {str -> namaPembeliValue = str}, true)
                    Spacer(Modifier.height(15.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDA853)),
                        onClick = {}
                    ) {
                        Text("Update")
                    }
                }
            }
        }
    }
}