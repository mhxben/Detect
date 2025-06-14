package com.example.detect.presentation.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.detect.data.model.Package
import com.example.detect.data.remote.RetrofitClient
import kotlinx.coroutines.launch

class getPackageByIdViewModel : ViewModel() {
    var Packages by mutableStateOf<Package?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    fun getPackageById( id : Int ){
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPackageById(id)
                if (response.isSuccessful){
                    Packages = response.body()
                }else{
                    errorMessage = response.errorBody()?.string() ?: "Unauthorized"
                }
            }catch (e:Exception){
                errorMessage = e.message ?: "Network error"
            }
        }
    }
}