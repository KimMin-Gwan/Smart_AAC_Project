package com.example.compass_aac.module

import com.example.data.source.remote.UserSource
import com.example.data.source.remote.UserSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class UserSourceModule {
    @Provides
    @Singleton
    fun provideUserSource(userSourceImpl: UserSourceImpl): UserSource = userSourceImpl
}