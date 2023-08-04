package com.example.data.api

import com.example.data.model.remote.VoiceCategoryResponse
import retrofit2.http.Body
import retrofit2.http.POST


data class Key(val key: String)

interface VoiceApiService {
    @POST("/get_string")
    suspend fun VoiceText(
        @Body key : Key
    ): VoiceCategoryResponse

}