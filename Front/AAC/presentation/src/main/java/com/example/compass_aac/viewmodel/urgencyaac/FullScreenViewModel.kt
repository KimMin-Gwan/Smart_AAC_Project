package com.example.compass_aac.viewmodel.urgencyaac

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class FullScreenViewModel @Inject constructor(@ApplicationContext context: Context) : ViewModel() {
    private val _urgencySentence = MutableLiveData<String>()
    val urgencySentence : LiveData<String> get() = _urgencySentence

    private val tts: TextToSpeech by lazy {
        TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.KOREAN
                Log.d("연결 성공", "연결 성공 ")
            } else {
                Log.e("TTS Error", "TTS engine initialization failed")
            }
        }
    }
    fun storeSentence(sentence:String){
        _urgencySentence.value = sentence
    }

    fun speakSentence(){
        viewModelScope.launch {
            val text = _urgencySentence.value ?: "선택된 문장이 없습니다"
//            voiceUseCase.speakSentence(text)
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)

        }
    }

    fun stopSentence(){
        viewModelScope.launch {
            tts.stop()
//            voiceUseCase.stopSpeaking()
        }
    }

    fun shutdownSentence(){
        viewModelScope.launch{
            tts.shutdown()
//            voiceUseCase.shutdown()
        }
    }
}