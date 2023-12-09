package com.example.webdigitaltask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.webdigitaltask.domain.model.Car

@Database(entities = [Car::class], version = 2)
abstract class CarDatabase : RoomDatabase() {

    abstract fun carDao() : CarDao
}