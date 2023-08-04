package com.example.compass_aac.viewmodel.voiceaac;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import com.example.json.NodeList;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.collections.ArrayList;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0017\u001a\u00020\u0018J,\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\bJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u0018J\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u001c\u001a\u00020\bJ\u000e\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\u00a8\u0006&"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/PassCategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "(Lcom/example/data/repository/FindNodeRepository;)V", "_categoryResult", "Landroidx/lifecycle/MutableLiveData;", "", "", "_categorylist", "_receivedCategory", "categoryResult", "Landroidx/lifecycle/LiveData;", "getCategoryResult", "()Landroidx/lifecycle/LiveData;", "categorylist", "getCategorylist", "receivedCategory", "getReceivedCategory", "MakeRootCategory", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "nodeList", "Lcom/example/json/NodeList;", "MakeRootGpsCategory", "categoryId", "calculateCategoryList", "categoryData", "defaultcalculateCategoryList", "defaultprocessNodes", "getCategory", "categorystring", "initCategoryData", "makeNode", "processNodes", "receiveCategory", "", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PassCategoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository findNodeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _categoryResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> categoryResult = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<java.lang.String>> _categorylist = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> categorylist = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _receivedCategory = null;
    
    @javax.inject.Inject
    public PassCategoryViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository findNodeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getCategoryResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<java.lang.String>> getCategorylist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getReceivedCategory() {
        return null;
    }
    
    public final void receiveCategory(@org.jetbrains.annotations.NotNull
    java.lang.String categoryData) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> initCategoryData(@org.jetbrains.annotations.NotNull
    java.lang.String categoryData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Integer> getCategory(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> categorystring) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.json.NodeList makeNode() {
        return null;
    }
    
    private final java.util.List<java.lang.String> calculateCategoryList(java.lang.String categoryData) {
        return null;
    }
    
    private final java.util.List<java.lang.String> defaultcalculateCategoryList(java.lang.String categoryData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> processNodes(@org.jetbrains.annotations.NotNull
    java.lang.String categoryData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> defaultprocessNodes(@org.jetbrains.annotations.NotNull
    java.lang.String categoryData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.Integer> MakeRootCategory(@org.jetbrains.annotations.NotNull
    com.example.json.NodeList nodeList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.Integer> MakeRootGpsCategory(@org.jetbrains.annotations.NotNull
    com.example.json.NodeList nodeList, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> categoryId) {
        return null;
    }
}