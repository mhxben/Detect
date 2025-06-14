package com.example.detect.presentation.view.component

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.detect.data.model.Package
import com.example.detect.data.model.PackageWithState
import com.example.detect.data.model.PanneState
import com.example.detect.data.model.utils.NotificationHelper
import com.example.detect.presentation.viewmodel.PackageSimulationViewModel
import com.example.detect.presentation.viewmodel.getPackageByIdViewModel


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

    var showCard by remember { mutableStateOf(false) }
    var selectedPanne by remember { mutableStateOf<PanneState?>(null) }

    val staticPackage = Package(
        id = 999,
        humidity = 60.0,
        temperature = 20.0,
        vibration = 0.2,
        type_de_colis = 1
    )

    LaunchedEffect(id) {
        viewModel.getPackageById(id)
    }

    LaunchedEffect(panne) {
        panne?.let {
            val issues = mutableListOf<String>()
            if (it.humidity == 1) issues.add("Humidity")
            if (it.temperature == 1) issues.add("Temperature")
            if (it.vibration == 1) issues.add("Vibration")

            if (issues.isNotEmpty()) {
                val msg = "🚨 Issue in: ${issues.joinToString(", ")}"
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
                NotificationHelper.showNotification(context, "Package Alert", msg)
            }
        }
    }

    if (pkg != null) {
        val packages = listOf(
            PackageWithState(pkg = pkg, panne = panne, lat = 36.7528, lon = 3.0422),
            PackageWithState(pkg = staticPackage, panne = PanneState(1, -1, -1), lat = 36.75, lon = 3.05)
        )

        Box(Modifier.fillMaxSize()) {
            MapboxMapView(
                packages = packages,
                onMarkerClick = { clicked ->
                    selectedPanne = clicked.panne
                    showCard = true
                }
            )

            if (showCard && selectedPanne != null) {
                IssueInfoCard(
                    panne = selectedPanne!!,
                    onClose = { showCard = false },
                    onFix = {
                        simViewModel.resolveIssue()
                        showCard = false
                    }
                )
            }
        }
    } else if (error != null) {
        Text(text = "Error: $error")
    } else {
        CircularProgressIndicator()
    }
}
