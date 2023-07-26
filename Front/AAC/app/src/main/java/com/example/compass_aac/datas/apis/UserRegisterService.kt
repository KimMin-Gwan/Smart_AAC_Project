/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 회원가입: retrofit + baseurl 서버 연결
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.datas.apis

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRegisterService {
    private val baseUrl = ""

    fun provideUserRegisterApiService(): UserRegisterApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserRegisterApiService::class.java)
    }
}