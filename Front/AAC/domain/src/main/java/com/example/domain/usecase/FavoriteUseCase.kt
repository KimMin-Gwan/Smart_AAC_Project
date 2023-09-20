package com.example.domain.usecase

import com.example.domain.model.favorite
import com.example.domain.repository.FavoriteRepository
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