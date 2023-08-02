package com.example.compass_aac.viewmodel.voiceaac;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.domain.usecase.ShowSelectedWordUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/ShowSelectedWordVIewModel;", "Landroidx/lifecycle/AndroidViewModel;", "showSelectedWordUseCase", "Lcom/example/domain/usecase/ShowSelectedWordUseCase;", "application", "Landroid/app/Application;", "(Lcom/example/domain/usecase/ShowSelectedWordUseCase;Landroid/app/Application;)V", "_textToRead", "Landroidx/lifecycle/MutableLiveData;", "", "textToRead", "Landroidx/lifecycle/LiveData;", "getTextToRead", "()Landroidx/lifecycle/LiveData;", "getText", "", "text", "onCleared", "resetData", "speakInf", "speakText", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ShowSelectedWordVIewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.ShowSelectedWordUseCase showSelectedWordUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _textToRead = null;
    
    @javax.inject.Inject
    public ShowSelectedWordVIewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.usecase.ShowSelectedWordUseCase showSelectedWordUseCase, @org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getTextToRead() {
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
    java.lang.String text) {
    }
    
    public final void resetData() {
    }
}