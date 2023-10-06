package com.example.domain.usecase

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject

class FavoriteVoiceUseCase @Inject constructor(private val textToSpeech: TextToSpeech, @ActivityContext context: Context) {
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
    fun speakSentence(sentence: String) {
        tts.speak(sentence, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun stopSpeaking() {
        tts.stop()
    }

    fun shutdown() {
        tts.shutdown()
    }
}