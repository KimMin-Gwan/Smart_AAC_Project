package com.example.compass_aac.viewmodel.voiceaac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.compass_aac.view.ConvertToCategoryString
import com.example.compass_aac.view.ConvertToId
import com.example.data.repository.FindNodeRepository
import com.example.data.repository.FindNodeRepositoryImpl
import com.example.data.source.remote.AAC_Tree
import com.example.data.source.remote.Tree_Node
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseWordPassViewModel @Inject constructor(private val findNodeRepository: FindNodeRepository): ViewModel() {

    private val _categories = MutableLiveData<String>()
    val categories: LiveData<String> get() = _categories
    var selectedCategory: String? = null

    init {
        _categories.value = selectedCategory
    }

    fun storeCategory(category: String) {
        selectedCategory = category
        Log.d("selectedCategory", selectedCategory!!)
        _categories.value = category
    }



    val _selectedWord = MutableLiveData<List<String>>()
    val selectedWord : LiveData<List<String>> get() = _selectedWord


    fun UpdateSelectedWord(sentence : List<String>){
        _selectedWord.value = sentence
    }

//    fun getCategoryId(selectedId : Int){
//        return findNodeRepository.RootNode(selectedId)
//    }

    fun getAAC_Tree(selectedId: Int): ArrayList<Tree_Node>{
        val child_string =  findNodeRepository.getAAC_Tree(selectedId)

        Log.d("child_string", child_string.toString())
        return child_string
    }

    fun processNodes(selectedcategory : String): ArrayList<Tree_Node> {
        val selectedId = ConvertToId(selectedcategory)
//        getCategoryId(selectedId)
        val child_stringList = getAAC_Tree(selectedId)
        return child_stringList

    }
    fun processUpdateNodes(it : String): ArrayList<Tree_Node>? {
//        val updatedcategory = _categories.value
//        val selectedId = updatedcategory?.let { ConvertToId(it) }
        val selectedId = ConvertToId(it)

//        getCategoryId(selectedId)
        val child_stringList = getAAC_Tree(selectedId)
        return child_stringList

    }

    fun getChildNodes(nowNode: Tree_Node) :ArrayList<Tree_Node>{
        val selectedId = nowNode.getId()
        Log.d("selectedId", selectedId.toString())
        return findNodeRepository.getAAC_Tree(selectedId)
    }

    fun updateCategory(category: String) {
        _categories.value = category
    }

    fun OnResetData(){
        _categories.value = ""
    }


}