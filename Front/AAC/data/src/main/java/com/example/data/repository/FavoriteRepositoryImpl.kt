package com.example.data.repository

import com.example.data.source.remote.local.FavoriteSource
import com.example.domain.model.favorite
import com.example.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val favoriteSource : FavoriteSource) : FavoriteRepository {
    override suspend fun getLists(): List<favorite> {
        return favoriteSource.getLists()
    }

    override suspend fun addList(text: String): List<favorite> {
        return favoriteSource.addList(text)
    }

    override suspend fun delList(id: Int): List<favorite> {
        return favoriteSource.delList(id)
    }
}