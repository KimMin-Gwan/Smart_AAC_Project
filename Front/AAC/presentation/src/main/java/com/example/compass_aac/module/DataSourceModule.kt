package com.example.compass_aac.module

import com.example.data.source.remote.LocationDataSource
import com.example.data.source.remote.LocationDataSourceImpl
import com.example.data.source.remote.UserSource
import com.example.data.source.remote.UserSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideLocationSource(LocationDataSourceImpl: LocationDataSourceImpl): LocationDataSource = LocationDataSourceImpl
}