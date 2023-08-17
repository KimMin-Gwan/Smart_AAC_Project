package com.example.compass_aac.view.voiceaac;

import android.content.ContentValues;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.compass_aac.databinding.ActivityChooseWordPassBinding;
import com.example.compass_aac.view.adapters.NodeAdapter;
import com.example.compass_aac.viewmodel.voiceaac.ChooseWordPassViewModel;
import com.example.data.source.remote.Tree_Node;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082.\u00a2\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b`\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ChooseWordPass;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/compass_aac/view/adapters/NodeAdapter;", "binding", "Lcom/example/compass_aac/databinding/ActivityChooseWordPassBinding;", "category", "", "child_list", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "clickedWord", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "selectedWord", "viewModel", "Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onStop", "Companion", "presentation_debug"})
public final class ChooseWordPass extends androidx.appcompat.app.AppCompatActivity {
    private com.example.compass_aac.view.adapters.NodeAdapter adapter;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.compass_aac.databinding.ActivityChooseWordPassBinding binding;
    private java.lang.String category;
    private java.util.ArrayList<com.example.data.source.remote.Tree_Node> child_list;
    @org.jetbrains.annotations.NotNull
    private final java.util.HashMap<java.lang.Integer, java.lang.String> clickedWord = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> selectedWord = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SELECTED_CATEGORY = "selectedCategory";
    @org.jetbrains.annotations.NotNull
    public static final com.example.compass_aac.view.voiceaac.ChooseWordPass.Companion Companion = null;
    
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
    
    @java.lang.Override
    protected void onPause() {
    }
    
    @java.lang.Override
    protected void onStop() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/ChooseWordPass$Companion;", "", "()V", "SELECTED_CATEGORY", "", "presentation_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}