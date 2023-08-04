package com.example.data.source.remote

import android.location.Location
import com.example.data.model.remote.CategoryResponse
import com.example.domain.model.Categories
import com.example.domain.model.LocationParam

interface LocationDataSource {
    suspend fun getLocation(): Result<Location?>

    suspend fun getCategories(param: LocationParam) : CategoryResponse
}