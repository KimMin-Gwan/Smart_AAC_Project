package com.example.compass_aac.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HearVoiceViewModel : ViewModel() {

    // 인식된 음성을 텍스트로 업데이트하기 위한 viewmodel
    val recognizedSpeechText = MutableLiveData<String>()
    val isEndOfSpeech = MutableLiveData<Boolean>()

    fun updateRecognizedSpeechText(text: String) {
        recognizedSpeechText.value = text
    }

    fun setEndOfSpeech(endOfSpeech: Boolean) {
        isEndOfSpeech.value = endOfSpeech
    }
}