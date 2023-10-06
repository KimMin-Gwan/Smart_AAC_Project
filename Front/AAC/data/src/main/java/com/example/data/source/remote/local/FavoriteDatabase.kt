package com.example.data.source.remote.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class FavoriteDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao

    companion object {
        private var instance: FavoriteDatabase? = null

        fun getInstance(context: Context): FavoriteDatabase {
            return instance ?: synchronized(this) {   //인스턴스가 이미 생성된 경우에는 해당 인스턴스를 반환
                instance ?: buildDatabase(context).also { instance = it } //그렇지 않은 경우에는 데이터베이스를 빌드하고 생성하고 반환
            }
        }

        //synchronized(): 두 개 이상의 스레드가 동시에 getInstance 메서드를 호출하는 경우에 한 스레드만 들어갈 수 있도록
        //여러 스레드에서 동시에 데이터베이스 인스턴스를 생성하는 것을 방지

        private fun buildDatabase(context: Context): FavoriteDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FavoriteDatabase::class.java,
                "favorite"
            ).build()
        }
    }
}