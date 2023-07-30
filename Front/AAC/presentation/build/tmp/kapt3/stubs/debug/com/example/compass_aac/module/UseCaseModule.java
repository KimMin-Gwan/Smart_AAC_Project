package com.example.compass_aac.module;

import com.example.domain.repository.LocationRepository;
import com.example.domain.repository.UserRepository;
import com.example.domain.usecase.LocationUseCase;
import com.example.domain.usecase.LoginUseCase;
import com.example.domain.usecase.RegisterUseCase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/example/compass_aac/module/UseCaseModule;", "", "()V", "provideLocationUseCase", "Lcom/example/domain/usecase/LocationUseCase;", "locationRepository", "Lcom/example/domain/repository/LocationRepository;", "provideLoginUseCase", "Lcom/example/domain/usecase/LoginUseCase;", "repository", "Lcom/example/domain/repository/UserRepository;", "provideRegisterUseCase", "Lcom/example/domain/usecase/RegisterUseCase;", "presentation_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class UseCaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.example.compass_aac.module.UseCaseModule INSTANCE = null;
    
    private UseCaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.usecase.LoginUseCase provideLoginUseCase(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.UserRepository repository) {
        return null;
    }
    
    @javax.inject.Singleton
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.usecase.RegisterUseCase provideRegisterUseCase(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.UserRepository repository) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.usecase.LocationUseCase provideLocationUseCase(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.LocationRepository locationRepository) {
        return null;
    }
}