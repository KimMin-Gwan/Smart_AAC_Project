package com.example.compass_aac.viewmodel.voiceaac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.repository.FindNodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseWordPassViewModel @Inject constructor(private val findNodeRepository: FindNodeRepository): ViewModel() {

    private val _categories = MutableLiveData<String>()
    val categories: LiveData<String> get() = _categories

    fun getFindNodeRepositoryImpl() = findNodeRepository

    fun returnIndex(Category:String) : Int {
       return findNodeRepository.returnIndex(Category)
    }

    fun MakeTree(index: Int): MutableList<String> {
        return findNodeRepository.MakeTree(index)
    }
    fun updateCategory(category: String) {
        _categories.postValue(category)
    }
}