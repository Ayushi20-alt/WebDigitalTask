package com.example.webdigitaltask.domain.usecase

import com.example.webdigitaltask.domain.model.Car
import com.example.webdigitaltask.domain.repository.CarRepository

class DeleteArticle(
    private val carRepository: CarRepository
) {

    suspend operator fun invoke(article: Car){
         carRepository.deleteArticle(article)
    }
}