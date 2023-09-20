package com.example.compass_aac.viewmodel.urgencyaac;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import com.example.data.source.remote.AAC_Tree;
import com.example.data.source.remote.Tree_Node;
import com.example.domain.usecase.UrgencyUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/compass_aac/viewmodel/urgencyaac/CategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/example/domain/usecase/UrgencyUseCase;", "repository", "Lcom/example/data/repository/FindNodeRepository;", "(Lcom/example/domain/usecase/UrgencyUseCase;Lcom/example/data/repository/FindNodeRepository;)V", "_selectedCategory", "Landroidx/lifecycle/MutableLiveData;", "", "selectedCategory", "Landroidx/lifecycle/LiveData;", "getSelectedCategory", "()Landroidx/lifecycle/LiveData;", "getCategory", "", "category", "getSentence", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "selectedId", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CategoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.UrgencyUseCase useCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _selectedCategory = null;
    
    @javax.inject.Inject
    public CategoryViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.usecase.UrgencyUseCase useCase, @org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getSelectedCategory() {
        return null;
    }
    
    public final void getCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> getSentence(int selectedId) {
        return null;
    }
}