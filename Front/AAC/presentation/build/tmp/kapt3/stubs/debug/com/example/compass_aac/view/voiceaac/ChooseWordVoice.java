package com.example.compass_aac.view.voiceaac;

import android.content.ContentValues;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.compass_aac.databinding.ActivityChooseWordVoiceBinding;
import com.example.compass_aac.view.adapters.NodeAdapter;
import com.example.compass_aac.view.adapters.VoiceAdapter;
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel;
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordVoiceViewModel;
import com.example.data.source.remote.Tree_Node;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0006j\b\u0012\u0004\u0012\u00020\f`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ChooseWordVoice;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/compass_aac/view/adapters/VoiceAdapter;", "childList", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "selectedWord", "", "getSelectedWord", "()Ljava/util/ArrayList;", "viewModel", "Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordVoiceViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordVoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class ChooseWordVoice extends androidx.appcompat.app.AppCompatActivity {
    private com.example.compass_aac.view.adapters.VoiceAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.ArrayList<com.example.data.source.remote.Tree_Node> childList;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> selectedWord = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    
    public ChooseWordVoice() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.voiceaac.ChooseWordVoiceViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getSelectedWord() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}