package com.example.compass_aac.view.voiceaac;

import android.content.ContentValues;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import com.example.compass_aac.databinding.ActivityShowSelectedWordBinding;
import com.example.compass_aac.view.MainActivity;
import com.example.compass_aac.view.favorite.FavoriteMain;
import com.example.compass_aac.viewmodel.user.UserPageViewModel;
import com.example.compass_aac.viewmodel.voiceaac.ShowSelectedWordVIewModel;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ShowSelectedWord;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/compass_aac/databinding/ActivityShowSelectedWordBinding;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "selectedCategory", "", "viewModel", "Lcom/example/compass_aac/viewmodel/voiceaac/ShowSelectedWordVIewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/voiceaac/ShowSelectedWordVIewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "formatText", "input", "wordsPerLine", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRestart", "onResume", "onStart", "onStop", "presentation_debug"})
public final class ShowSelectedWord extends androidx.appcompat.app.AppCompatActivity {
    private java.lang.String selectedCategory;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    private com.example.compass_aac.databinding.ActivityShowSelectedWordBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    @javax.inject.Inject
    public ShowSelectedWord() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.voiceaac.ShowSelectedWordVIewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.lang.String formatText(java.lang.String input, int wordsPerLine) {
        return null;
    }
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    @java.lang.Override
    protected void onRestart() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    protected void onResume() {
    }
    
    @java.lang.Override
    protected void onStart() {
    }
}