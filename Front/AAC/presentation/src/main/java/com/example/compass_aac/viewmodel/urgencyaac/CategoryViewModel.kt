package com.example.compass_aac.viewmodel.urgencyaac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repository.FindNodeRepository
import com.example.data.source.remote.AAC_Tree
import com.example.data.source.remote.Tree_Node
import com.example.domain.usecase.UrgencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val useCase: UrgencyUseCase, private val repository: FindNodeRepository) : ViewModel() {

    private val _selectedCategory = MutableLiveData<String>()
    val selectedCategory : LiveData<String> get() = _selectedCategory


    //선택하는 카테고리 저장
    fun getCategory(category: String){
        _selectedCategory.value = category
        Log.d("success", category)
    }

    fun getSelectedCategory(): String{
        return _selectedCategory.value ?: "null"
    }


    fun getSentence(selectedId: Int): ArrayList<Tree_Node>{
        return repository.getAAC_Urgency_Tree(selectedId)
    }

}