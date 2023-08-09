package com.example.data.api

import com.example.data.model.remote.CategoryResponse
import com.example.data.model.remote.LocationRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface LocationApiService {
    @POST("/get_gps")
    suspend fun locationXY(
        @Body request: LocationRequest
    ):CategoryResponse
}