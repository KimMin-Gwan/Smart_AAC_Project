package com.example.compass_aac.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PassCategoryViewModel : ViewModel() {
    private val _categoryResult = MutableLiveData<Result<List<String>>>()
    val categoryResult: LiveData<Result<List<String>>> = _categoryResult

    fun initCategoryData(categoryData: String) {
        val categories = categoryData.split(", ")
        Log.d("categories", categories.toString())
        _categoryResult.value = Result.success(categories)
    }
}