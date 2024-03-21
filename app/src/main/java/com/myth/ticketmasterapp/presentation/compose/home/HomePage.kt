package com.myth.ticketmasterapp.presentation.compose.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
//Top App bar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = { Icon(Icons.Default.Menu, contentDescription = "Menu") }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            //Search Bar
            // Category Chips
            // Popular event section
            // Event's near you
        }
    }

}
