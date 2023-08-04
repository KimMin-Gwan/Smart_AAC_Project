package com.example.domain.repository

import com.example.domain.model.KeyParam
import com.example.domain.model.VoiceCategory

interface VoiceRepository{
    suspend fun VoiceCategory(voicetext : KeyParam) : VoiceCategory
}