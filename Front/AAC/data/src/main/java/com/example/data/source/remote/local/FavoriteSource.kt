package com.example.data.source.remote.local

import com.example.domain.model.favorite

interface FavoriteSource {

    suspend fun getLists(): List<favorite>

    suspend fun addList(text:String) :List<favorite>

    suspend fun delList(id:Int) : List<favorite>
}