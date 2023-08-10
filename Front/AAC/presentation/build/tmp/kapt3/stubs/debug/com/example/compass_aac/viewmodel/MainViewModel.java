package com.example.compass_aac.viewmodel;

import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/compass_aac/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "(Lcom/example/data/repository/FindNodeRepository;)V", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository findNodeRepository = null;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository findNodeRepository) {
        super();
    }
}