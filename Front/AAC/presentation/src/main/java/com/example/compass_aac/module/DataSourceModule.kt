package com.example.compass_aac.module

import com.example.data.source.remote.LocationDataSource
import com.example.data.source.remote.LocationDataSourceImpl
import com.example.data.source.remote.UserDataSource
import com.example.data.source.remote.UserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    fun provideUserSource(userSourceImpl: UserDataSourceImpl): UserDataSource = userSourceImpl

    @Provides
    fun provideLocationSource(LocationDataSourceImpl: LocationDataSourceImpl): LocationDataSource = LocationDataSourceImpl

}