package com.example.webdigitaltask.data.repository

import com.example.webdigitaltask.data.local.CarDao
import com.example.webdigitaltask.data.remote.CarApi
import com.example.webdigitaltask.data.remote.dto.logindto.Login
import com.example.webdigitaltask.data.remote.dto.logindto.LoginResponse
import com.example.webdigitaltask.data.remote.dto.registerdto.Register
import com.example.webdigitaltask.data.remote.dto.registerdto.RegisterResponse
import com.example.webdigitaltask.domain.model.Car
import com.example.webdigitaltask.domain.repository.CarRepository
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CarRepositoryImp @Inject constructor(
    private val carApi: CarApi,
    private val carDao: CarDao
) : CarRepository {
    override suspend fun loginUser(body: Login): ApiResponse<LoginResponse> = carApi.getLogin(body)

    override suspend fun registerUser(body: Register): ApiResponse<RegisterResponse> = carApi.getresistered(body)
    override suspend fun upsertArticle(article: Car) {
        carDao.insertCar(article)
    }

    override suspend fun deleteArticle(article: Car) {
        carDao.deleteCar(article)
    }

    override fun selectedArticle(): Flow<List<Car>> {
       return carDao.getAllCars()
    }

}