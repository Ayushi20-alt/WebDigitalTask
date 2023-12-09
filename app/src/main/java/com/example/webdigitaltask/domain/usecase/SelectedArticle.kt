package com.example.webdigitaltask.domain.usecase

import com.example.webdigitaltask.domain.model.Car
import com.example.webdigitaltask.domain.repository.CarRepository
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val carRepository: CarRepository
) {

    operator fun invoke(): Flow<List<Car>> {
        return carRepository.selectedArticle()
    }
}