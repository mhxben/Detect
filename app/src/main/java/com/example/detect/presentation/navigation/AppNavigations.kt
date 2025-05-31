package com.example.detect.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.detect.presentation.view.HomePage
import com.example.detect.presentation.view.LandingPage
import com.example.detect.presentation.view.LoginPage

@Composable
fun AppNavigations(){
    val navController = rememberNavController()
    NavHost(navController , NavigationRoutes.Landing){
        composable(NavigationRoutes.Landing) { LandingPage(navController) }
        composable(NavigationRoutes.Login) { LoginPage(navController) }
        composable(NavigationRoutes.Home) { HomePage(navController) }
    }
}