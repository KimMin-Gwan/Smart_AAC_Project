package com.example.data.source.remote.local

import android.content.Context
import com.example.data.mapper.MapperToFavorite
import com.example.data.source.remote.local.FavoriteSource
import com.example.domain.model.favorite
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FavoriteSourceImpl @Inject constructor(@ApplicationContext private val context : Context) : FavoriteSource {
    override suspend fun getLists(): List<favorite> {
        val favoriteDao = FavoriteDatabase.getInstance(context).favoriteDao()
        val sentences = favoriteDao.getAllFavorites()

        return MapperToFavorite(sentences)
    }

    override suspend fun addList(text: String): List<favorite> {
        // FavoriteEntity 생성
        val favorite = FavoriteEntity(sentence = text)

        // 데이터베이스에 추가
        val favoriteDao = FavoriteDatabase.getInstance(context).favoriteDao()
        favoriteDao.insertFavorite(favorite)

        //전체 리스트
        val favoriteDao2 = FavoriteDatabase.getInstance(context).favoriteDao()
        val sentences = favoriteDao2.getAllFavorites()

        return MapperToFavorite(sentences)
    }

    override suspend fun delList(id: Int): List<favorite> {
        val favoriteDao3 = FavoriteDatabase.getInstance(context).favoriteDao()

        val favoriteEntity = favoriteDao3.getFavoriteById(id.toLong())// 아이템 ID로 조회
        favoriteEntity?.let {
            favoriteDao3.delete(it) // 아이템 삭제
        }
        // 새로운 목록을 반환하거나 필요에 따라 다른 작업 수행
        //전체 리스트
        val sentences = favoriteDao3.getAllFavorites()

        return MapperToFavorite(sentences)

    }
}