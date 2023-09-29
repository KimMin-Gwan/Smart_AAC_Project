package com.example.compass_aac.module;

import android.speech.tts.TextToSpeech;
import com.example.data.repository.FavoriteRepositoryImpl;
import com.example.data.repository.FindNodeRepositoryImpl;
import com.example.data.repository.LocationRepositoryImpl;
import com.example.data.repository.UserRepositoryImpl;
import com.example.data.repository.FindNodeRepository;
import com.example.data.repository.VoiceRepositoryImpl;
import com.example.domain.repository.FavoriteRepository;
import com.example.domain.repository.LocationRepository;
import com.example.domain.repository.UserRepository;
import com.example.domain.repository.VoiceRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.Module
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\'\u00a8\u0006\u0017"}, d2 = {"Lcom/example/compass_aac/module/RepositoryModule;", "", "()V", "bindFavoriteRepository", "Lcom/example/domain/repository/FavoriteRepository;", "favoriteRepositoryImpl", "Lcom/example/data/repository/FavoriteRepositoryImpl;", "bindFindNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "findNodeRepositoryImpl", "Lcom/example/data/repository/FindNodeRepositoryImpl;", "bindLocationRepository", "Lcom/example/domain/repository/LocationRepository;", "locationRepositoryImpl", "Lcom/example/data/repository/LocationRepositoryImpl;", "bindUserRepository", "Lcom/example/domain/repository/UserRepository;", "userRepositoryImpl", "Lcom/example/data/repository/UserRepositoryImpl;", "bindVoiceRepository", "Lcom/example/domain/repository/VoiceRepository;", "voiceRepositoryImpl", "Lcom/example/data/repository/VoiceRepositoryImpl;", "presentation_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.UserRepository bindUserRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.UserRepositoryImpl userRepositoryImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.LocationRepository bindLocationRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.LocationRepositoryImpl locationRepositoryImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.data.repository.FindNodeRepository bindFindNodeRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepositoryImpl findNodeRepositoryImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.VoiceRepository bindVoiceRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.VoiceRepositoryImpl voiceRepositoryImpl);
    
    @dagger.Binds
    @org.jetbrains.annotations.NotNull
    public abstract com.example.domain.repository.FavoriteRepository bindFavoriteRepository(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FavoriteRepositoryImpl favoriteRepositoryImpl);
}