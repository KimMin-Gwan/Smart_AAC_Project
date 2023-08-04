package com.example.data.source.remote

import com.example.data.api.Key
import com.example.data.model.remote.VoiceCategoryResponse

interface VoiceDataSource {

    suspend fun getVoiceCategory(
        key: Key
    ) : VoiceCategoryResponse

}