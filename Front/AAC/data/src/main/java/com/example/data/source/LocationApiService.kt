package com.example.data.source

import com.example.data.model.remote.CategoryResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LocationApiService {
    @FormUrlEncoded
    @POST("/location")
    suspend fun locationXY(
        @Field("nx") nx : Double,
        @Field("ny") ny : Double
    ): List<CategoryResponse>
}