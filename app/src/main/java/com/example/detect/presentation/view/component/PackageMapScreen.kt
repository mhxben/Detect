package com.example.detect.presentation.view.component

import android.widget.Toast
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.detect.data.model.utils.NotificationHelper
import com.example.detect.presentation.viewmodel.getPackageByIdViewModel
import com.example.detect.presentation.viewmodel.PackageSimulationViewModel

@Composable
fun PackageMapScreen(
    viewModel: getPackageByIdViewModel,
    simViewModel: PackageSimulationViewModel,
    id: Int
) {
    val pkg = viewModel.Packages
    val error = viewModel.errorMessage
    val panne = simViewModel.panneState.value
    val context = LocalContext.current

    LaunchedEffect(id) {
        viewModel.getPackageById(id)
    }

    LaunchedEffect(panne) {
        panne?.let {
            val issues = mutableListOf<String>()
            if (it.humidity == -1) issues.add("Humidity")
            if (it.temperature == -1) issues.add("Temperature")
            if (it.vibration == -1) issues.add("Vibration")

            if (issues.isNotEmpty()) {
                val msg = "🚨 Issue in: ${issues.joinToString(", ")}"

                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()

                NotificationHelper.showNotification(context, "Package Alert", msg)
            }
        }
    }



    if (pkg != null) {
        MapboxMapView(pkg = pkg, lat = 36.7528, lon = 3.0422, panneState = panne)
    } else if (error != null) {
        Text(text = "Error: $error")
    } else {
        CircularProgressIndicator()
    }
}
