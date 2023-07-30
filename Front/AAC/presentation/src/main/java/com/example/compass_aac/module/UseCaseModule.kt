package com.example.compass_aac.module

import com.example.domain.repository.LocationRepository
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.LocationUseCase
import com.example.domain.usecase.LoginUseCase
import com.example.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideLoginUseCase(repository: UserRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideRegisterUseCase(repository:UserRepository) : RegisterUseCase{
        return RegisterUseCase(repository)
    }

    @Provides
    fun provideLocationUseCase(locationRepository: LocationRepository): LocationUseCase {
        return LocationUseCase(locationRepository)
    }
}