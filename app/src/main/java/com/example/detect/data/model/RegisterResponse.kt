package com.example.detect.data.model

data class RegisterResponse(
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val phone: String
)