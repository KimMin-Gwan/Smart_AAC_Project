package com.example.compass_aac.viewmodel.favorite;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.domain.usecase.FavoriteUseCase;
import com.example.domain.usecase.FavoriteVoiceUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.util.Locale;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/compass_aac/viewmodel/favorite/FavoriteVoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "voiceUseCase", "Lcom/example/domain/usecase/FavoriteVoiceUseCase;", "context", "Landroid/content/Context;", "(Lcom/example/domain/usecase/FavoriteVoiceUseCase;Landroid/content/Context;)V", "_favoriteSentence", "Landroidx/lifecycle/MutableLiveData;", "", "favoriteSentence", "Landroidx/lifecycle/LiveData;", "getFavoriteSentence", "()Landroidx/lifecycle/LiveData;", "tts", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "tts$delegate", "Lkotlin/Lazy;", "shutdownSentence", "", "speakSentence", "stopSentence", "storeSentence", "sentence", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FavoriteVoiceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.FavoriteVoiceUseCase voiceUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _favoriteSentence = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy tts$delegate = null;
    
    @javax.inject.Inject
    public FavoriteVoiceViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.usecase.FavoriteVoiceUseCase voiceUseCase, @dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getFavoriteSentence() {
        return null;
    }
    
    private final android.speech.tts.TextToSpeech getTts() {
        return null;
    }
    
    public final void storeSentence(@org.jetbrains.annotations.NotNull
    java.lang.String sentence) {
    }
    
    public final void speakSentence() {
    }
    
    public final void stopSentence() {
    }
    
    public final void shutdownSentence() {
    }
}