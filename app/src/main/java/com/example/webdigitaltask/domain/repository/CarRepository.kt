package com.example.webdigitaltask.domain.repository

import com.example.webdigitaltask.data.remote.dto.logindto.Login
import com.example.webdigitaltask.data.remote.dto.logindto.LoginResponse
import com.example.webdigitaltask.data.remote.dto.registerdto.Register
import com.example.webdigitaltask.data.remote.dto.registerdto.RegisterResponse
import com.example.webdigitaltask.domain.model.Car
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CarRepository {

    suspend fun loginUser(body : Login) : ApiResponse<LoginResponse>

    suspend fun registerUser(body : Register) : ApiResponse<RegisterResponse>

    suspend fun upsertArticle(article: Car)

    suspend fun deleteArticle(article: Car)

    fun selectedArticle(): Flow<List<Car>>
}