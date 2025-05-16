package com.example.telurapps.screens

import SelectDate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AktivitasScreen(navController: NavController) {
    val activityOptions = listOf(
        "Menyapu",
        "Membersihkan Sarang Laba-laba",
        "Membersihkan Kotoran Ayam",
        "Membersihkan Pipa Pakan",
        "Membersihkan Pipa Air Minum",
        "Memperbaiki Kandang")
    var expanded by remember { mutableStateOf(false) }
    var selectedActivity by remember { mutableStateOf(activityOptions[0]) }
    var masukValue by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Aktivitas")
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
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(" Update Aktivitas", fontSize = 20.sp)
                Spacer(Modifier.height(10.dp))
                Row {
//                    SelectDate()
                    Spacer(Modifier.width(5.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDA853)),
                        onClick = {}
                    ) {
                        Text("Update")
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box {
                        androidx.compose.material3.OutlinedTextField(
                            value = selectedActivity,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Aktivitas") },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.ArrowDropDown,
                                    contentDescription = null,
                                    modifier = Modifier.clickable { expanded = true }
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        androidx.compose.material3.DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            activityOptions.forEach { activity ->
                                androidx.compose.material3.DropdownMenuItem(
                                    text = { Text(activity) },
                                    onClick = {
                                        selectedActivity = activity
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Button(
                        onClick = {
                            println("Selected activity: $selectedActivity")
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDDA853))
                    ) {
                        Text("Simpan")
                    }
                }
            }
        }
    }
}