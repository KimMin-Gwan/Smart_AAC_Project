package com.example.compass_aac.viewmodel.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserPageViewModel :ViewModel() {

    private val _customize : MutableLiveData<String>  = MutableLiveData()
    val customize : LiveData<String> get() = _customize

    private val _fixedText : MutableLiveData<String> = MutableLiveData()
    val fixedText: LiveData<String> get() = _fixedText

    fun updateCustomize(text: String){
        _customize.value = text
    }

    fun fixedText(fixedText: String){
        _fixedText.value= fixedText
    }

}