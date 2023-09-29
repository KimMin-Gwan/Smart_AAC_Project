package com.example.compass_aac.module

import android.speech.tts.TextToSpeech
import com.example.data.repository.FavoriteRepositoryImpl
import com.example.data.repository.FindNodeRepositoryImpl
import com.example.data.repository.LocationRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.data.repository.FindNodeRepository
import com.example.data.repository.VoiceRepositoryImpl
import com.example.domain.repository.FavoriteRepository
import com.example.domain.repository.LocationRepository
import com.example.domain.repository.UserRepository
import com.example.domain.repository.VoiceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun bindLocationRepository(locationRepositoryImpl: LocationRepositoryImpl) : LocationRepository


    @Binds
    abstract fun bindFindNodeRepository(findNodeRepositoryImpl: FindNodeRepositoryImpl) : FindNodeRepository

    @Binds
    abstract fun bindVoiceRepository(voiceRepositoryImpl: VoiceRepositoryImpl): VoiceRepository

    @Binds
    abstract fun bindFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl) : FavoriteRepository
}