package com.example.compass_aac.module

import com.example.domain.repository.LocationRepository
import com.example.domain.usecase.LocationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object LocationUseCaseModule {
    @Provides
    fun provideLocationUseCase(locationRepository: LocationRepository): LocationUseCase{
        return LocationUseCase(locationRepository)
    }
}