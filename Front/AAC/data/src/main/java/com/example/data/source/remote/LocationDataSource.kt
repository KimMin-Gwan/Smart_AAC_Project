package com.example.data.source.remote

import android.location.Location
import com.example.data.model.remote.CategoryResponse
import com.example.domain.model.Categories

interface LocationDataSource {
    suspend fun getLocation(): Result<Location?>

    suspend fun getCategories(x: Double, y: Double) : List<CategoryResponse>
}