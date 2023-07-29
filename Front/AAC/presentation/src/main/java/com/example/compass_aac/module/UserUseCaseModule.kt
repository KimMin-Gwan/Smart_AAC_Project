package com.example.compass_aac.module

import com.example.domain.model.Register
import com.example.domain.repository.UserRepository
import com.example.domain.usecase.LoginUseCase
import com.example.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {
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
}