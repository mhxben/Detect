package com.example.detect.data.model

data class RegisterRequest(
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String,
    val password2: String,
    val phone: String
)