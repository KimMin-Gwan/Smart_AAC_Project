package com.example.domain.usecase

import android.speech.tts.TextToSpeech
import javax.inject.Inject

class ShowSelectedWordUseCase @Inject constructor(private val textToSpeech: TextToSpeech) {
    fun speakText(text: String) {
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    fun stopSpeaking() {
        textToSpeech.stop()
    }

    fun shutdown() {
        textToSpeech.shutdown()
    }
}