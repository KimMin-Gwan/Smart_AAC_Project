package com.example.compass_aac.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.NodeRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor( private val nodeRepository: NodeRepositoryImpl) : ViewModel() {


    private val _node = MutableLiveData<String>()
    val node :LiveData<String> get() = _node

    fun makeNode() {

    viewModelScope.launch {
        val node_list = nodeRepository.getNodeList()
    }

//        Log.d("node", node_list.getSize().toString())
    }

}