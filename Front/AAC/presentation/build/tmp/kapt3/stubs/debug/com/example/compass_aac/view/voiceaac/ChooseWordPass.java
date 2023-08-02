package com.example.compass_aac.view.voiceaac;

import android.content.ContentValues;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.compass_aac.R;
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding;
import com.example.compass_aac.databinding.ActivityPassCategoryBinding;
import com.example.compass_aac.view.adapters.NodeAdapter;
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel;
import com.example.compass_aac.viewmodel.voiceaac.HearVoiceViewModel;
import com.example.data.repository.FindNodeRepositoryImpl;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ChooseWordPass;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/compass_aac/view/adapters/NodeAdapter;", "binding", "Lcom/example/compass_aac/databinding/ActivityChooseWordPassBinding;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "viewModel", "Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class ChooseWordPass extends androidx.appcompat.app.AppCompatActivity {
    private com.example.compass_aac.view.adapters.NodeAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    private com.example.compass_aac.databinding.ActivityChooseWordPassBinding binding;
    
    public ChooseWordPass() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}