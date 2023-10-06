package com.example.compass_aac.module

import androidx.lifecycle.ViewModel
import com.example.data.api.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(ViewModelScoped::class)
class UserModule {
    @ViewModelScoped
    @Provides
    fun provideLoginApi(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

}