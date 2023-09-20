package com.example.compass_aac.view.urgencyaac;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import com.example.compass_aac.R;
import com.example.compass_aac.databinding.ActivityUrgencySentenceBinding;
import com.example.compass_aac.viewmodel.urgencyaac.CategoryViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.IOException;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/compass_aac/view/urgencyaac/UrgencySentence;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "viewModel", "Lcom/example/compass_aac/viewmodel/urgencyaac/CategoryViewModel;", "CategoryId", "", "category", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "presentation_debug"})
public final class UrgencySentence extends androidx.appcompat.app.AppCompatActivity {
    private com.example.compass_aac.viewmodel.urgencyaac.CategoryViewModel viewModel;
    
    public UrgencySentence() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final int CategoryId(java.lang.String category) {
        return 0;
    }
}