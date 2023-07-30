package com.example.compass_aac.view.voiceaac;

import android.content.ContentValues;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import com.example.compass_aac.R;
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding;
import com.example.compass_aac.databinding.ActivityShowSelectedWordBinding;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Locale;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ShowSelectedWord;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "binding", "Lcom/example/compass_aac/databinding/ActivityShowSelectedWordBinding;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "textToSpeech", "Landroid/speech/tts/TextToSpeech;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInit", "status", "", "presentation_debug"})
public final class ShowSelectedWord extends androidx.appcompat.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    private android.speech.tts.TextToSpeech textToSpeech;
    private com.example.compass_aac.databinding.ActivityShowSelectedWordBinding binding;
    
    public ShowSelectedWord() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}