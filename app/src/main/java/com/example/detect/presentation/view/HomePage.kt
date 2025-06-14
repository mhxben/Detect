package com.example.detect.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.detect.data.remote.RetrofitClient
import com.example.detect.presentation.view.component.*
import com.example.detect.presentation.viewmodel.PackageSimulationViewModel
import com.example.detect.presentation.viewmodel.getPackageByIdViewModel

@Composable
fun HomePage(navController: NavController) {
    val api = remember { RetrofitClient.instance }
    val viewModel = remember { getPackageByIdViewModel() }
    val simViewModel = remember { PackageSimulationViewModel(api, id = 1) }

    Scaffold(
        topBar = { HomeAppBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PackageMapScreen(
                viewModel = viewModel,
                simViewModel = simViewModel,
                id = 1
            )
        }
    }
}
