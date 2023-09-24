package com.example.compass_aac.viewmodel.voiceaac;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import com.example.data.source.remote.Tree_Node;
import com.example.domain.model.KeyParam;
import com.example.domain.model.VoiceCategory;
import com.example.domain.usecase.VoiceUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\r\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ \u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/ChooseWordVoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "voiceUseCase", "Lcom/example/domain/usecase/VoiceUseCase;", "(Lcom/example/data/repository/FindNodeRepository;Lcom/example/domain/usecase/VoiceUseCase;)V", "_category", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/example/domain/model/VoiceCategory;", "category", "Landroidx/lifecycle/LiveData;", "getCategory", "()Landroidx/lifecycle/LiveData;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "getAAC_Tree", "Ljava/util/ArrayList;", "Lcom/example/data/source/remote/Tree_Node;", "Lkotlin/collections/ArrayList;", "selectedId", "", "Lkotlinx/coroutines/Job;", "voiceText", "", "processNodes", "selectedCategory", "processUpdateNodes", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ChooseWordVoiceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository findNodeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.VoiceUseCase voiceUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<com.example.domain.model.VoiceCategory>> _category = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<kotlin.Result<com.example.domain.model.VoiceCategory>> category = null;
    
    @javax.inject.Inject
    public ChooseWordVoiceViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository findNodeRepository, @org.jetbrains.annotations.NotNull
    com.example.domain.usecase.VoiceUseCase voiceUseCase) {
        super();
    }
    
    private final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Result<com.example.domain.model.VoiceCategory>> getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> getAAC_Tree(int selectedId) {
        return null;
    }
    
    private final java.util.ArrayList<com.example.data.source.remote.Tree_Node> processNodes(java.lang.String selectedCategory) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<com.example.data.source.remote.Tree_Node> processUpdateNodes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job getCategory(@org.jetbrains.annotations.NotNull
    java.lang.String voiceText) {
        return null;
    }
}