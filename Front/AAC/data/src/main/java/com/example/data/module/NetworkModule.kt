package com.example.data.module

import com.example.data.source.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val baseUrl = ""

    @Singleton
    @Provides
//    fun provideUserApiService(): UserApiService {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(UserApiService::class.java)
//    }
    fun provideRetrofit(okHttp: OkHttpClient) : Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            client(okHttp)
            baseUrl(baseUrl)
        }.build()
    }
}