package com.example.compass_aac.datas.apis

import com.example.compass_aac.datas.CategoryResponse
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