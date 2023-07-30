package com.example.compass_aac.module;

import com.example.data.source.remote.LocationDataSource;
import com.example.data.source.remote.LocationDataSourceImpl;
import com.example.data.source.remote.UserDataSource;
import com.example.data.source.remote.UserDataSourceImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module(includes = {com.example.compass_aac.module.NetworkModule.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/example/compass_aac/module/DataSourceModule;", "", "()V", "provideLocationSource", "Lcom/example/data/source/remote/LocationDataSource;", "LocationDataSourceImpl", "Lcom/example/data/source/remote/LocationDataSourceImpl;", "provideUserSource", "Lcom/example/data/source/remote/UserDataSource;", "userSourceImpl", "Lcom/example/data/source/remote/UserDataSourceImpl;", "presentation_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataSourceModule {
    
    public DataSourceModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.data.source.remote.UserDataSource provideUserSource(@org.jetbrains.annotations.NotNull
    com.example.data.source.remote.UserDataSourceImpl userSourceImpl) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.data.source.remote.LocationDataSource provideLocationSource(@org.jetbrains.annotations.NotNull
    com.example.data.source.remote.LocationDataSourceImpl LocationDataSourceImpl) {
        return null;
    }
}