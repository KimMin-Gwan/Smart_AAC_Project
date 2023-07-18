package com.example.compass_aac.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HearVoiceViewModel : ViewModel() {

    // LiveData for the recognized speech text
    val recognizedSpeechText = MutableLiveData<String>()
    val isEndOfSpeech = MutableLiveData<Boolean>()

    fun updateRecognizedSpeechText(text: String) {
        recognizedSpeechText.value = text
    }

    fun setEndOfSpeech(endOfSpeech: Boolean) { // 추가된 줄
        isEndOfSpeech.value = endOfSpeech
    }
}