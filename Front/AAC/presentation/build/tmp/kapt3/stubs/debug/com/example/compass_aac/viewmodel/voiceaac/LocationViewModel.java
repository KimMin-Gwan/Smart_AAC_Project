package com.example.compass_aac.viewmodel.voiceaac;

import android.app.Application;
import android.location.Location;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.data.api.LocationRequest;
import com.example.domain.model.Categories;
import com.example.domain.model.LocationParam;
import com.example.domain.usecase.LocationUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00118F\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/compass_aac/viewmodel/voiceaac/LocationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "usecase", "Lcom/example/domain/usecase/LocationUseCase;", "application", "Landroid/app/Application;", "(Lcom/example/domain/usecase/LocationUseCase;Landroid/app/Application;)V", "_categoryResult", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Result;", "Lcom/example/domain/model/Categories;", "get_categoryResult", "()Landroidx/lifecycle/MutableLiveData;", "_isLoading", "", "get_isLoading", "categoryResult", "Landroidx/lifecycle/LiveData;", "getCategoryResult", "()Landroidx/lifecycle/LiveData;", "isLoading", "fetchLocationAsync", "Lkotlinx/coroutines/Job;", "presentation_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class LocationViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.domain.usecase.LocationUseCase usecase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<kotlin.Result<com.example.domain.model.Categories>> _categoryResult = null;
    
    @javax.inject.Inject
    public LocationViewModel(@org.jetbrains.annotations.NotNull
    com.example.domain.usecase.LocationUseCase usecase, @org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> get_isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<kotlin.Result<com.example.domain.model.Categories>> get_categoryResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Result<com.example.domain.model.Categories>> getCategoryResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job fetchLocationAsync() {
        return null;
    }
}