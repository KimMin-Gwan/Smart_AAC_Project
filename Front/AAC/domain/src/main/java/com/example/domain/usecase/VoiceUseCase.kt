package com.example.domain.usecase

import com.example.domain.model.KeyParam
import com.example.domain.model.VoiceCategory
import com.example.domain.repository.VoiceRepository
import javax.inject.Inject

class VoiceUseCase @Inject constructor(private val voiceRepository: VoiceRepository){
    suspend fun voiceCategory(key:KeyParam) : VoiceCategory{
        return voiceRepository.VoiceCategory(key)
    }
}