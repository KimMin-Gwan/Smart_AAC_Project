package com.example.data.mapper

import com.example.data.model.remote.VoiceCategoryResponse
import com.example.domain.model.VoiceCategory

fun MapperToVoiceCategory(Voicecategory: VoiceCategoryResponse): VoiceCategory {
    return (VoiceCategory(Voicecategory.key))
}