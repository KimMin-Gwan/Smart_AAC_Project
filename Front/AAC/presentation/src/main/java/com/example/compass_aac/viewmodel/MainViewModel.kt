package com.example.compass_aac.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.FindNodeRepository
import com.example.json.Node
import com.example.json.NodeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.util.ArrayList
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor( private val findNodeRepository: FindNodeRepository) : ViewModel() {


    private val _node = MutableLiveData<String>()
    val node :LiveData<String> get() = _node

//    fun makeNode() : NodeList {
//        return findNodeRepository.MakeNode()
//    }
//    fun processNodes() {
//        val nodeList = makeNode()
//        MakeRootCategory(nodeList)
//    }
//    fun MakeRootCategory(nodeList: NodeList) :ArrayList<Int> {
//        return findNodeRepository.MakeRootCategory(nodeList)
//
//    }




}