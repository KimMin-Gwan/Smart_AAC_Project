package com.example.compass_aac.viewmodel.favorite

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.FavoriteUseCase
import com.example.domain.usecase.FavoriteVoiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class FavoriteVoiceViewModel @Inject constructor( private val voiceUseCase: FavoriteVoiceUseCase, @ApplicationContext context: Context) : ViewModel(){

    private val _favoriteSentence = MutableLiveData<String>()
    val favoriteSentence : LiveData<String> get() = _favoriteSentence

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
        _favoriteSentence.value = sentence
    }

    fun speakSentence(){
        viewModelScope.launch {
            val text = _favoriteSentence.value ?: "선택된 문장이 없습니다"
//            voiceUseCase.speakSentence(text)
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)

        }
    }

    fun stopSentence(){
        viewModelScope.launch {
//            voiceUseCase.stopSpeaking()
        }
    }

    fun shutdownSentence(){
        viewModelScope.launch{
//            voiceUseCase.shutdown()
        }
    }

}