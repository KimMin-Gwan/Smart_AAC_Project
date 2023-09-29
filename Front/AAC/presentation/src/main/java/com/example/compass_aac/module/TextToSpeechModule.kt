package com.example.compass_aac.module

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Toast
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
                Log.d("연결 성공", "연결 성공")
                tts.language = Locale.KOREAN
            }
            else{
                Toast.makeText(context, "연결하는데 실패하였습니다." , Toast.LENGTH_SHORT).show()
                Log.d("연결 실패", "연결 실패")
            }
        })
        return tts
    }
}