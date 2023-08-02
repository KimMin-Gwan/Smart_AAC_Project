package com.example.compass_aac.viewmodel.voiceaac;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepositoryImpl;
import com.example.data.repository.NodeRepositoryImpl;
import com.example.data.repository.TreeRepositoryImpl;
import com.example.data.source.remote.AAC_Tree;
import com.example.data.source.remote.Node;
import com.example.data.source.remote.Tree_Node;
import com.example.domain.repository.FindNodeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/domain/repository/FindNodeRepository;", "(Lcom/example/domain/repository/FindNodeRepository;)V", "_categories", "Landroidx/lifecycle/MutableLiveData;", "", "categories", "Landroidx/lifecycle/LiveData;", "getCategories", "()Landroidx/lifecycle/LiveData;", "MakeTree", "", "index", "", "getFindNodeRepositoryImpl", "returnIndex", "Category", "updateCategory", "", "category", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ChooseWordPassViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.repository.FindNodeRepository findNodeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _categories = null;
    
    @javax.inject.Inject
    public ChooseWordPassViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.repository.FindNodeRepository findNodeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.domain.repository.FindNodeRepository getFindNodeRepositoryImpl() {
        return null;
    }
    
    public final int returnIndex(@org.jetbrains.annotations.NotNull
    java.lang.String Category) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> MakeTree(int index) {
        return null;
    }
    
    public final void updateCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
}