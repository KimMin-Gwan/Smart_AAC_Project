package com.example.data.source.remote.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoriteDao {
    //아이템 추가
    @Insert
    suspend fun insertFavorite(favorite: FavoriteEntity)

    //아이템 전체
    @Query("SELECT * FROM favorite")
    suspend fun getAllFavorites(): List<FavoriteEntity>

    // 아이템 삭제
    @Delete
    suspend fun delete(favorite: FavoriteEntity)

    // 아이템 ID로 조회
    @Query("SELECT * FROM favorite WHERE id = :id")
    suspend fun getFavoriteById(id: Long): FavoriteEntity?

    // 다수의 아이템 삭제
    @Delete
    suspend fun deleteFavorites(favorites: List<FavoriteEntity>)

}