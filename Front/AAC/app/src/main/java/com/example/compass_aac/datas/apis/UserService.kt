/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 로그인: 레트로핏 + baseurl 서버 연결
 * - baseurl 채우기
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.datas.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserService {
    private val baseUrl = ""

    fun provideUserApiService(): UserApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }
}

