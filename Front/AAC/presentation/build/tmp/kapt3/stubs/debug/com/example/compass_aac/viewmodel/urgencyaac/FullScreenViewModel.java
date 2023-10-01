package com.example.compass_aac.viewmodel.urgencyaac;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Locale;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/example/compass_aac/viewmodel/urgencyaac/FullScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_urgencySentence", "Landroidx/lifecycle/MutableLiveData;", "", "tts", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "tts$delegate", "Lkotlin/Lazy;", "urgencySentence", "Landroidx/lifecycle/LiveData;", "getUrgencySentence", "()Landroidx/lifecycle/LiveData;", "shutdownSentence", "", "speakSentence", "stopSentence", "storeSentence", "sentence", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class FullScreenViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _urgencySentence = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy tts$delegate = null;
    
    @javax.inject.Inject
    public FullScreenViewModel(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getUrgencySentence() {
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