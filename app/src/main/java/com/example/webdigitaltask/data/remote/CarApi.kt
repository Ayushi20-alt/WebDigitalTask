package com.example.webdigitaltask.data.remote

import com.example.webdigitaltask.data.remote.dto.logindto.Login
import com.example.webdigitaltask.data.remote.dto.logindto.LoginResponse
import com.example.webdigitaltask.data.remote.dto.registerdto.Register
import com.example.webdigitaltask.data.remote.dto.registerdto.RegisterResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CarApi {

    @POST("login")
    suspend fun getLogin(@Body body: Login): ApiResponse<LoginResponse>

    @POST("register")
    suspend fun getresistered(@Body body : Register): ApiResponse<RegisterResponse>

}