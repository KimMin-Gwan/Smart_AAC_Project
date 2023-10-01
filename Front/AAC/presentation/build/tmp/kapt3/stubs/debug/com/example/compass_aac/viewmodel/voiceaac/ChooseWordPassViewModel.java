package com.example.compass_aac.viewmodel.voiceaac;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import com.example.data.repository.FindNodeRepositoryImpl;
import com.example.data.source.remote.AAC_Tree;
import com.example.data.source.remote.Tree_Node;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0014\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\"\u001a\u00020\u001dJ\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010$\u001a\u00020\u0007J\"\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cj\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001`\u001e2\u0006\u0010&\u001a\u00020\u0007J\u000e\u0010\'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordPassViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "(Lcom/example/data/repository/FindNodeRepository;)V", "_categories", "Landroidx/lifecycle/MutableLiveData;", "", "_selectedWord", "", "get_selectedWord", "()Landroidx/lifecycle/MutableLiveData;", "categories", "Landroidx/lifecycle/LiveData;", "getCategories", "()Landroidx/lifecycle/LiveData;", "selectedCategory", "getSelectedCategory", "()Ljava/lang/String;", "setSelectedCategory", "(Ljava/lang/String;)V", "selectedWord", "getSelectedWord", "OnResetData", "", "UpdateSelectedWord", "sentence", "getAAC_Tree", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "selectedId", "", "getChildNodes", "nowNode", "processNodes", "selectedcategory", "processUpdateNodes", "it", "storeCategory", "category", "updateCategory", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ChooseWordPassViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository findNodeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _categories = null;
    @org.jetbrains.annotations.Nullable
    private java.lang.String selectedCategory;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _selectedWord = null;
    
    @javax.inject.Inject
    public ChooseWordPassViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository findNodeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSelectedCategory() {
        return null;
    }
    
    public final void setSelectedCategory(@org.jetbrains.annotations.Nullable
    java.lang.String p0) {
    }
    
    public final void storeCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> get_selectedWord() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getSelectedWord() {
        return null;
    }
    
    public final void UpdateSelectedWord(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> sentence) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> getAAC_Tree(int selectedId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> processNodes(@org.jetbrains.annotations.NotNull
    java.lang.String selectedcategory) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> processUpdateNodes(@org.jetbrains.annotations.NotNull
    java.lang.String it) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> getChildNodes(@org.jetbrains.annotations.NotNull
    com.example.data.source.remote.Tree_Node nowNode) {
        return null;
    }
    
    public final void updateCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    public final void OnResetData() {
    }
}