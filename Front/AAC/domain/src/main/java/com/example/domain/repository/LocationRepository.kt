package com.example.domain.repository

import android.location.Location
import com.example.domain.model.Categories

interface LocationRepository {
    suspend fun getLocation(): Result<Location?>

    suspend fun getCategories(x : Double, y: Double) : List<Categories>
}