package com.example.webdigitaltask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val color: String,
    val carType: String,
    val model: String,
    val cost: String
)