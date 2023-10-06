package com.example.compass_aac.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ViewModelScoped::class)
object NetworkModule {
    private val baseUrl = "http://13.125.205.99/"


    //provides를 사용하면 외부 라이브러리 객체의 경우도 Dependency 제공 가능
    @Provides
    fun provideOkHttpClient(): OkHttpClient {  // 다양한 네트워크 관련 설정을 제공
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)// 읽기 및 연결 시간 초과를 30초
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    @Provides
    fun provideRetrofit(okHttp: OkHttpClient) : Retrofit {
        return Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create()) //JSON 응답을 파싱하기 위한 Gson converter 추가
            client(okHttp) //OkHttpClient와 연결하여 네트워크 관련 설정 효과적으로 활용
            baseUrl(baseUrl)
        }.build()
    }

}