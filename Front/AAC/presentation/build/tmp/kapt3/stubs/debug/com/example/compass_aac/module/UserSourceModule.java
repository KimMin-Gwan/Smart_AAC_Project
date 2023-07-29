package com.example.compass_aac.module;

import com.example.data.source.remote.UserSource;
import com.example.data.source.remote.UserSourceImpl;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module(includes = {com.example.compass_aac.module.NetworkModule.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/example/compass_aac/module/UserSourceModule;", "", "()V", "provideUserSource", "Lcom/example/data/source/remote/UserSource;", "userSourceImpl", "Lcom/example/data/source/remote/UserSourceImpl;", "presentation_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class UserSourceModule {
    
    public UserSourceModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.data.source.remote.UserSource provideUserSource(@org.jetbrains.annotations.NotNull
    com.example.data.source.remote.UserSourceImpl userSourceImpl) {
        return null;
    }
}