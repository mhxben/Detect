package com.example.detect.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.detect.presentation.view.component.*

@Composable
fun HomePage(navController: NavController){
    Scaffold (
        topBar = { HomeAppBar() }
    ) {innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            MapboxMapView()
        }
    }
}