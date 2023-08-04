package com.example.compass_aac.module

import com.example.data.api.VoiceApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class VoiceModule {
    @Singleton
    @Provides
    fun provideVoiceApi(retrofit: Retrofit):VoiceApiService{
        return retrofit.create(VoiceApiService::class.java)
    }
}