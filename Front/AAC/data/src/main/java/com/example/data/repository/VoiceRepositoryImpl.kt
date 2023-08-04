package com.example.data.repository

import com.example.data.api.Key
import com.example.data.mapper.MapperToKeyParam
import com.example.data.mapper.MapperToVoiceCategory
import com.example.data.source.remote.VoiceDataSource
import com.example.domain.model.KeyParam
import com.example.domain.model.VoiceCategory
import com.example.domain.repository.VoiceRepository
import javax.inject.Inject

class VoiceRepositoryImpl @Inject constructor(private val voiceDataSource: VoiceDataSource) : VoiceRepository {
    override suspend fun VoiceCategory(voicetext: KeyParam): VoiceCategory {
        val key = MapperToKeyParam(voicetext)
        val response = voiceDataSource.getVoiceCategory(key)
        return MapperToVoiceCategory(response)
    }
}