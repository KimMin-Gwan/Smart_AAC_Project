package com.example.compass_aac.viewmodel.voiceaac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.view.ConvertCategoryId
import com.example.compass_aac.view.ConvertToCategoryString
import com.example.data.repository.FindNodeRepository
import com.example.json.NodeList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.collections.ArrayList


@HiltViewModel
class PassCategoryViewModel @Inject constructor(private val findNodeRepository: FindNodeRepository): ViewModel() {
    private val _categoryResult = MutableLiveData<List<String>>()
    val categoryResult: LiveData<List<String>> = _categoryResult

    private val _categorylist = MutableLiveData<List<String>>()
    val categorylist : LiveData<List<String>> = _categorylist


    private val _receivedCategory = MutableLiveData<String>()
    val receivedCategory : LiveData<String> get() =  _receivedCategory

    fun receiveCategory(categoryData: String){
        _receivedCategory.postValue(categoryData)
    }


    fun initCategoryData(categoryData: String) : List<String> {
        val categories  = categoryData.split(",")  //공백있으면 공백 추가
        Log.d("categories", categories.toString())
        _categoryResult.postValue(categories)
        return categories
    }


    //가져온 카테고리 문자열을 id로변환
    fun getCategory(categorystring: List<String>): List<Int> {
        Log.d("category", categorystring.toString())
        val categoryId = ConvertCategoryId(categorystring!!)

        return categoryId
    }

    fun makeNode() : NodeList {
        return findNodeRepository.MakeNode()
    }
    private fun calculateCategoryList(categoryData: String): List<String> {
        val categorystring = initCategoryData(categoryData)
        val nodeList = makeNode()
        val categoryid = getCategory(categorystring)

        //위치기반 우선 카테고리 가져오기
        val categorygpsfinal = MakeRootGpsCategory(nodeList, categoryid)

        val convertstring = ConvertToCategoryString(categorygpsfinal)
        Log.d("convertString", convertstring.toString())

        return convertstring
    }
    private fun defaultcalculateCategoryList(categoryData: String): List<String> {
        val categorystring = initCategoryData(categoryData)
        val nodeList = makeNode()
        val categoryid = getCategory(categorystring)

        //위치기반 우선 카테고리 가져오기
        val categoryfinal = MakeRootCategory(nodeList)
        val convertstring = ConvertToCategoryString(categoryfinal)
        Log.d("convertString", convertstring.toString())

        return convertstring
    }

    fun processNodes(categoryData: String) :List<String> {

        val categoryList = calculateCategoryList(categoryData)
        return categoryList
    }

    fun defaultprocessNodes(categoryData: String):List<String> {
        val categoryList = defaultcalculateCategoryList(categoryData)
        return categoryList
    }

    fun MakeRootCategory(nodeList: NodeList) :ArrayList<Int> {
        return findNodeRepository.MakeRootCategory(nodeList)
    }

    fun MakeRootGpsCategory(nodeList: NodeList, categoryId: List<Int>) :ArrayList<Int> {
        return findNodeRepository.MakeRootGpsCategory(nodeList, categoryId)
    }
}