package com.mdi.learnandroidcleanarchitecture.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text("MDI Store") },
        actions = {
            IconButton(onClick = { /* Do something */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
        }
    )
}