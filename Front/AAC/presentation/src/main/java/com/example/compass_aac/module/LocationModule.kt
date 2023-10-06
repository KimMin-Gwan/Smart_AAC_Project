package com.example.compass_aac.module

import android.content.Context
import com.example.data.api.LocationApiService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [NetworkModule::class])
@InstallIn(ViewModelScoped::class)
class LocationModule {

    @ViewModelScoped
    @Provides
    fun provideLocationApi(retrofit: Retrofit) : LocationApiService {
        return retrofit.create(LocationApiService::class.java)
    }

    @ViewModelScoped
    @Provides
    fun provideFusedLocationProviderClient(@ActivityContext context: Context): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(context)
    }
}