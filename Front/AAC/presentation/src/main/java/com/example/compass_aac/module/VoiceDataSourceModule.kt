package com.example.compass_aac.module

import com.example.data.source.remote.VoiceDataSource
import com.example.data.source.remote.VoiceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
    @InstallIn(SingletonComponent::class)
abstract class VoiceDataSourceModule {
    @Binds
    abstract fun bindVoiceDataSource(voiceDataSourceImpl: VoiceDataSourceImpl): VoiceDataSource
}