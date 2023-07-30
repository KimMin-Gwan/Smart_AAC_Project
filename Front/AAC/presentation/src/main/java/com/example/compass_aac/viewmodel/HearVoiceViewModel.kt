package com.example.compass_aac.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


//@HiltViewModel
class HearVoiceViewModel : ViewModel() {

    // 인식된 음성을 텍스트로 업데이트하기 위한 viewmodel
     var recognizedSpeechText = MutableLiveData<String>()
     var isEndOfSpeech = MutableLiveData<Boolean>()


    fun updateRecognizedSpeechText(text: String) {
        recognizedSpeechText.value = text
    }

    fun setEndOfSpeech(endOfSpeech: Boolean) {
        isEndOfSpeech.value = endOfSpeech
    }


    fun resetData() {
        recognizedSpeechText.value = "음성인식 버튼을 눌러주세요."
        isEndOfSpeech.value =false
    }
}