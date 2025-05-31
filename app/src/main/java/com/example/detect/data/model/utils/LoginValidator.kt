package com.example.detect.data.model.utils

import com.example.detect.data.model.LoginRequest

object LoginValidator {
    fun loginValidationInfo(request : LoginRequest) : String?{
        return when {
            request.email.isBlank() && request.password.isBlank() ->{
                return "Please fill your information"
            }
            request.email.isBlank() ->{
                return "Please enter your password"
            }
            request.password.isBlank() ->{
                return "Please enter your password"
            }
            else -> null
        }
    }
}