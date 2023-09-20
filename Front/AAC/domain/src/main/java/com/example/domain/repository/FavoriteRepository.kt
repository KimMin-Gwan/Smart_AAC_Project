package com.example.domain.repository

import com.example.domain.model.favorite

interface FavoriteRepository {

    suspend fun getLists(): List<favorite>

    suspend fun addList(text :String) : List<favorite>

    suspend fun delList(id: Int) : List<favorite>
}