package com.example.detect.data.model.utils

import android.util.Patterns
import com.example.detect.data.model.LoginRequest

object LoginValidator {
    fun loginValidationInfo(request: LoginRequest): String? {
        return when {
            request.email.isBlank() && request.password.isBlank() -> {
                "Please fill in your email and password"
            }
            request.email.isBlank() -> {
                "Please enter your email"
            }
            !Patterns.EMAIL_ADDRESS.matcher(request.email).matches() -> {
                "Invalid email format"
            }
            request.password.isBlank() -> {
                "Please enter your password"
            }
            request.password.length < 6 -> {
                "Password must be at least 6 characters"
            }
            else -> null
        }
    }
}
