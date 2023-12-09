package com.example.webdigitaltask.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.webdigitaltask.domain.model.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

        @Query("SELECT * FROM Car")
        fun getAllCars(): Flow<List<Car>>

        @Insert
        fun insertCar(car: Car)


        @Delete
        fun deleteCar(car: Car)
}