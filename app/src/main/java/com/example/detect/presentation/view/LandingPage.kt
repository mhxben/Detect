package com.example.detect.presentation.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.detect.R
import com.example.detect.presentation.navigation.NavigationActions
import com.example.detect.ui.theme.PrimaryColor
import kotlinx.coroutines.delay

@Composable
fun LandingPage(navController: NavController){
    LaunchedEffect (Unit){
        delay(2000)
        NavigationActions.navigationToLogin(navController)
    }
    Box(
        Modifier.fillMaxSize().background(PrimaryColor),
        contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource( id = R.drawable.logo),
            contentDescription = null,
            Modifier.size(100.dp)
        )
    }
}