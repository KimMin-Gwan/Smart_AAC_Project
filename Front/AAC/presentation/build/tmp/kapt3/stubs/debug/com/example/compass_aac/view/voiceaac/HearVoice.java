package com.example.compass_aac.view.voiceaac;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.compass_aac.databinding.ActivityHearVoiceBinding;
import com.example.compass_aac.viewmodel.HearVoiceViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/HearVoice;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "recognitionListener", "Landroid/speech/RecognitionListener;", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "viewModel", "Lcom/example/compass_aac/viewmodel/HearVoiceViewModel;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestPermission", "setListener", "presentation_debug"})
public final class HearVoice extends androidx.appcompat.app.AppCompatActivity {
    private android.speech.SpeechRecognizer speechRecognizer;
    private android.speech.RecognitionListener recognitionListener;
    private com.example.compass_aac.viewmodel.HearVoiceViewModel viewModel;
    
    public HearVoice() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void requestPermission() {
    }
    
    private final void setListener() {
    }
}