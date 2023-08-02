package com.example.compass_aac.viewmodel.voiceaac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PassCategoryViewModel @Inject constructor(): ViewModel() {
    private val _categoryResult = MutableLiveData<List<String>>()
    val categoryResult: LiveData<List<String>> = _categoryResult

    fun initCategoryData(categoryData: String) {
        val categories = categoryData.split(",") //공백있으면 공백 추가
        Log.d("categories", categories.toString())
        _categoryResult.value = categories
    }

}