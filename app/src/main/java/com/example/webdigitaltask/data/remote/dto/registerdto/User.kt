package com.example.webdigitaltask.data.remote.dto.registerdto

data class User(
    val address: String,
    val city: String,
    val created_at: String,
    val email: String,
    val id: Int,
    val name: String,
    val password_hint: String,
    val phone: String,
    val pincode: String,
    val updated_at: String
)