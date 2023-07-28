package com.example.compass_aac.data.source

import com.example.compass_aac.data.dto.CategoryResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LocationApiService {
    @FormUrlEncoded
    @POST("")
    suspend fun locationXY(
        @Field("nx") nx : Double,
        @Field("ny") ny : Double
    ): Response<CategoryResponse>
}