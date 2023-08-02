package com.example.compass_aac.view.login;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.OnBackPressedCallback;
import com.example.compass_aac.view.MainActivity;
import com.example.compass_aac.R;
import com.example.compass_aac.databinding.ActivityLoginMainBinding;
import com.example.compass_aac.viewmodel.login.LoginViewModel;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/example/compass_aac/view/login/LoginMain;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "viewModel", "Lcom/example/compass_aac/viewmodel/login/LoginViewModel;", "getViewModel", "()Lcom/example/compass_aac/viewmodel/login/LoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkLoginButtonStatus", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class LoginMain extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.OnBackPressedCallback onBackPressedCallback = null;
    
    public LoginMain() {
        super();
    }
    
    private final com.example.compass_aac.viewmodel.login.LoginViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final void checkLoginButtonStatus() {
    }
}