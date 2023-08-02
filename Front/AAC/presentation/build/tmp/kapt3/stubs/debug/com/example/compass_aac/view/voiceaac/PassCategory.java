package com.example.compass_aac.view.voiceaac;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.compass_aac.view.adapters.PassCategoryAdapter;
import com.example.compass_aac.databinding.ActivityPassCategoryBinding;
import com.example.compass_aac.viewmodel.voiceaac.PassCategoryViewModel;
import com.example.compass_aac.view.MainActivity;
import com.example.compass_aac.view.location.SearchLocation;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/example/compass_aac/view/voiceaac/PassCategory;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backPressedTime", "", "binding", "Lcom/example/compass_aac/databinding/ActivityPassCategoryBinding;", "callback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "viewModel", "Lcom/example/compass_aac/viewmodel/voiceaac/PassCategoryViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/voiceaac/PassCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class PassCategory extends androidx.appcompat.app.AppCompatActivity {
    private long backPressedTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.compass_aac.databinding.ActivityPassCategoryBinding binding;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback callback = null;
    
    public PassCategory() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.voiceaac.PassCategoryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}