package com.example.compass_aac.viewmodel.voiceaac

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compass_aac.view.ConvertToId
import com.example.data.repository.FindNodeRepository
import com.example.data.source.remote.Tree_Node
import com.example.domain.model.KeyParam
import com.example.domain.model.VoiceCategory
import com.example.domain.usecase.VoiceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class ChooseWordVoiceViewModel @Inject constructor(private val findNodeRepository: FindNodeRepository, private val voiceUseCase: VoiceUseCase) :ViewModel() {

    private val _category = MutableLiveData<Result<VoiceCategory>>()
    val category :LiveData<Result<VoiceCategory>> = _category


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


    fun getCategory(voiceText : String)= viewModelScope.launch{
        withContext(Dispatchers.IO){
            try {
                Log.d("voiceText", voiceText)
                val keyparam = KeyParam(voiceText)
                val response = voiceUseCase.voiceCategory(keyparam)
                _category.postValue(Result.success(response))

                Log.d("response", response.key)


            } catch (e:Exception){
                Log.d("VoiceViewModel", "${e.message}")
            }

        }
    }
}