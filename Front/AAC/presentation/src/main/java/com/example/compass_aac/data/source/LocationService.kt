package com.example.compass_aac.data.source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LocationService {

    private val baseUrl = ""

    fun providelocationApiService(): LocationApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LocationApiService::class.java)
    }

}