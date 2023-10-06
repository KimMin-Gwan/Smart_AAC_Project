package com.example.compass_aac.module

import com.example.data.api.VoiceApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(ViewModelScoped::class)
class VoiceModule {
    @ViewModelScoped
    @Provides
    fun provideVoiceApi(retrofit: Retrofit):VoiceApiService{
        return retrofit.create(VoiceApiService::class.java)
    }
}