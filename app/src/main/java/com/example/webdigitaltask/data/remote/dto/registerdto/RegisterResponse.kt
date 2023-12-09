package com.example.webdigitaltask.data.remote.dto.registerdto

data class RegisterResponse(
    val message: String,
    val token: String,
    val user: User
)