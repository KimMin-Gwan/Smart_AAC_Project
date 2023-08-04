package com.example.domain.repository

import android.location.Location
import com.example.domain.model.Categories
import com.example.domain.model.LocationParam

interface LocationRepository {
    suspend fun getLocation(): Result<Location?>

    suspend fun getCategories(param: LocationParam) : Categories
}