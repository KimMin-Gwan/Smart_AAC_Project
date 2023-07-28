package com.example.compass_aac.module

import com.example.data.source.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class LocationModule {

    @Singleton
    @Provides
    fun provideLacationApi(retrofit: Retrofit) : LocationApiService{
        return retrofit.create(LocationApiService::class.java)
    }
}