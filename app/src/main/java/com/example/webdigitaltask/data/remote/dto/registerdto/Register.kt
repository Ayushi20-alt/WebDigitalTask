package com.example.webdigitaltask.data.remote.dto.registerdto

data class Register(
    val name : String,
    val gender : String,
    val age : Int,
    val phone : String,
    val email : String,
    val address : String,
    val city : String,
    val password : String,
    val confirm : String,
    val pincode : String
)