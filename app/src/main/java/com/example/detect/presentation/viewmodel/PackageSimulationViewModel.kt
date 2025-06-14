package com.example.detect.presentation.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.detect.data.model.PannePredetect
import com.example.detect.data.model.PanneState
import com.example.detect.data.remote.AppApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class PackageSimulationViewModel(
    private val api: AppApi,
    private val id: Int
) : ViewModel() {

    private val _panneState = mutableStateOf<PanneState?>(null)
    val panneState: State<PanneState?> = _panneState

    init {
        startSimulation()
    }

    private fun startSimulation() {
        viewModelScope.launch {
            while (true) {
                delay(10000)

                val humidity = if (Random.nextInt(100) < 20) -1.0 else Random.nextDouble(20.0, 90.0)
                val temperature = if (Random.nextInt(100) < 20) -1.0 else Random.nextDouble(10.0, 60.0)
                val vibration = if (Random.nextInt(100) < 20) -1.0 else Random.nextDouble(0.0, 1.0)

                val predetect = PannePredetect(
                    humidity = humidity,
                    temperature = temperature,
                    vibration = vibration
                )

                val response = api.getPackageStatePane(id, predetect)
                if (response.isSuccessful) {
                    _panneState.value = response.body()
                }
            }
        }
    }
}
