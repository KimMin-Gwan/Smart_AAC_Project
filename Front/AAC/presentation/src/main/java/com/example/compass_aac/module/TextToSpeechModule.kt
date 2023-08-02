package com.example.compass_aac.module

import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.Locale


@Module
@InstallIn(SingletonComponent::class)
object TextToSpeechModule {

    @Provides
    fun provideTextToSpeech(@ApplicationContext context: Context): TextToSpeech {
        lateinit var tts: TextToSpeech
        tts = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
            // TTS 초기화 코드
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.KOREAN
            }
        })
        return tts
    }
}