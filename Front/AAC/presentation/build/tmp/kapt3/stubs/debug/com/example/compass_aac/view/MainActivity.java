package com.example.compass_aac.view;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import com.example.compass_aac.databinding.ActivityMainBinding;
import com.example.compass_aac.view.dailyaac.DailyCategory;
import com.example.compass_aac.view.urgencyaac.UrgencyCategory;
import com.example.compass_aac.view.location.SearchLocation;
import com.example.compass_aac.view.login.TitleActivity;
import com.example.compass_aac.view.user.UserPage;
import com.example.compass_aac.viewmodel.MainViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/compass_aac/view/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backPressedTime", "", "viewModel", "Lcom/example/compass_aac/viewmodel/MainViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private long backPressedTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}