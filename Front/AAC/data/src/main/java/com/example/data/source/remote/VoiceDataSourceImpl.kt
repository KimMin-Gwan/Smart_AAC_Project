package com.example.data.source.remote

import com.example.data.api.Key
import com.example.data.api.VoiceApiService
import com.example.data.model.remote.VoiceCategoryResponse
import javax.inject.Inject

class VoiceDataSourceImpl @Inject constructor(private val voiceApiService: VoiceApiService) : VoiceDataSource{
    override suspend fun getVoiceCategory(key: Key): VoiceCategoryResponse {
        return voiceApiService.VoiceText(key)
    }

}