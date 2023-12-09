package com.example.webdigitaltask.presentation.Car

import com.example.webdigitaltask.domain.model.Car

data class CarState (
    val articles : List<Car> = emptyList()
)