package com.example.compass_aac.viewmodel.voiceaac;

import android.app.Application;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.domain.usecase.ShowSelectedWordUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\u0011J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0006\u0010\u001e\u001a\u00020\u001aJ\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\u000bj\b\u0012\u0004\u0012\u00020\t`\u00110\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/ShowSelectedWordVIewModel;", "Landroidx/lifecycle/AndroidViewModel;", "showSelectedWordUseCase", "Lcom/example/domain/usecase/ShowSelectedWordUseCase;", "application", "Landroid/app/Application;", "(Lcom/example/domain/usecase/ShowSelectedWordUseCase;Landroid/app/Application;)V", "_customizedText", "Landroidx/lifecycle/MutableLiveData;", "", "_textToRead", "Ljava/util/ArrayList;", "customizedText", "Landroidx/lifecycle/LiveData;", "getCustomizedText", "()Landroidx/lifecycle/LiveData;", "textToRead", "Lkotlin/collections/ArrayList;", "getTextToRead", "tts", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "tts$delegate", "Lkotlin/Lazy;", "getText", "", "text", "getTextInf", "onCleared", "resetData", "speakInf", "speakText", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ShowSelectedWordVIewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.ShowSelectedWordUseCase showSelectedWordUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy tts$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.ArrayList<java.lang.String>> _textToRead = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _customizedText = null;
    
    @javax.inject.Inject
    public ShowSelectedWordVIewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.usecase.ShowSelectedWordUseCase showSelectedWordUseCase, @org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    private final android.speech.tts.TextToSpeech getTts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.ArrayList<java.lang.String>> getTextToRead() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getCustomizedText() {
        return null;
    }
    
    public final void speakText() {
    }
    
    public final void speakInf() {
    }
    
    @java.lang.Override
    public void onCleared() {
    }
    
    public final void getText(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> text) {
    }
    
    public final void getTextInf(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    public final void resetData() {
    }
}