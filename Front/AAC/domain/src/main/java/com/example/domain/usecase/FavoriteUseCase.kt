package com.example.domain.usecase

import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModel
import com.example.domain.model.favorite
import com.example.domain.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class FavoriteUseCase @Inject constructor(private val repository: FavoriteRepository) {

    suspend fun getLists() : List<favorite>{
        return repository.getLists()
    }

    suspend fun addList(text:String) : List<favorite>{
        return repository.addList(text)
    }

    suspend fun delList(id:Int) : List<favorite>{
        return repository.delList(id)
    }

}