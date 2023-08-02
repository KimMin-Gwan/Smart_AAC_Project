package com.example.compass_aac.module

import android.content.Context
import com.example.data.repository.NodeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NodeRepository  {

    @Singleton
    @Provides
    fun provideNodeRepositoryImpl(@ApplicationContext context: Context): NodeRepositoryImpl {
        return NodeRepositoryImpl(context)
    }
}