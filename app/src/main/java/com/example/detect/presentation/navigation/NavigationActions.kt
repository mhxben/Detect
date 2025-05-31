package com.example.detect.presentation.navigation

import androidx.navigation.NavController

object NavigationActions {
    fun navigationToLogin(navController: NavController){
        navController.navigate(NavigationRoutes.Login){
            popUpTo(NavigationRoutes.Landing){ inclusive = true}
        }
    }
    fun navigateToHome(navController: NavController){
        navController.navigate(NavigationRoutes.Home){
            popUpTo(NavigationRoutes.Login){ inclusive = true}
        }
    }
}