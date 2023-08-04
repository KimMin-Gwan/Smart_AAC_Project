package com.example.compass_aac.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.data.repository.FindNodeRepository;
import com.example.json.Node;
import com.example.json.NodeList;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Dispatcher;
import java.util.ArrayList;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/compass_aac/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "findNodeRepository", "Lcom/example/data/repository/FindNodeRepository;", "(Lcom/example/data/repository/FindNodeRepository;)V", "_node", "Landroidx/lifecycle/MutableLiveData;", "", "node", "Landroidx/lifecycle/LiveData;", "getNode", "()Landroidx/lifecycle/LiveData;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.data.repository.FindNodeRepository findNodeRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _node = null;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.example.data.repository.FindNodeRepository findNodeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.String> getNode() {
        return null;
    }
}