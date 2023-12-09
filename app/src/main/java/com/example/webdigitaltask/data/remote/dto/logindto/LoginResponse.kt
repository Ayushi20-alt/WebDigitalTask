package com.example.webdigitaltask.data.remote.dto.logindto

data class LoginResponse(
    val access_token: String,
    val expires_in: Int,
    val token_type: String,
    val user: User
)