package com.example.compass_aac.viewmodel.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.favorite
import com.example.domain.usecase.FavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteMainViewModel @Inject constructor(private val useCase: FavoriteUseCase) :ViewModel() {

    //즐겨찾기에 넣을 새로운 값
    private val _edittext = MutableLiveData<String>()
    val edittext : LiveData<String> get() = _edittext

    //디비에 저장되어있는 목록
    private val _lists = MutableLiveData<List<favorite>>()
    val lists : LiveData<List<favorite>> get() = _lists

    fun editText(text : String){
        _edittext.value = text
    }

    suspend fun getLists(): List<favorite>{
        val result = useCase.getLists()
        _lists.postValue(result)

        Log.d("데이터 전체", result.toString())
        return useCase.getLists()
    }

    suspend fun addList(text :String){
        val result = useCase.addList(text)
        Log.d("데이터 추가", result.toString())

        _lists.postValue(result)
    }

    suspend fun delList(id:Int):List<favorite>{
        val result = useCase.delList(id)
        Log.d("데이터 삭제", result.toString())
        _lists.postValue(result)
        return result
    }
}