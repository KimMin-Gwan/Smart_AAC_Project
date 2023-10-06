package com.example.compass_aac.module

import com.example.data.source.remote.LocationDataSource
import com.example.data.source.remote.LocationDataSourceImpl
import com.example.data.source.remote.UserDataSource
import com.example.data.source.remote.UserDataSourceImpl
import com.example.data.source.remote.local.FavoriteSource
import com.example.data.source.remote.local.FavoriteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

//이 모듈에서 네트워크 관련 의존성을 사용
@Module(includes = [NetworkModule::class])
@InstallIn(ViewModelComponent::class)
class DataSourceModule {

    // 해당 객체들을 필요로 하는 다른 클래스나 컴포넌트에서 의존성을 주입
    @Provides
    fun provideUserSource(userSourceImpl: UserDataSourceImpl): UserDataSource = userSourceImpl

    @Provides
    fun provideLocationSource(LocationDataSourceImpl: LocationDataSourceImpl): LocationDataSource = LocationDataSourceImpl

    @Provides
    fun provideFavoriteSource(favoriteSourceImpl: FavoriteSourceImpl) : FavoriteSource = favoriteSourceImpl

}