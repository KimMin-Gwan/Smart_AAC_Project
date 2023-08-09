/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - 서버에 요청 보낼 데이터 형식
 * - post("") 란에 baseurl 뒤 주소 넣기
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.data.api

import com.example.data.model.remote.LoginRequest
import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterRequest
import com.example.data.model.remote.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST


//사용자 정보
interface UserApiService {
    //로그인, json
    @POST("/login")
    suspend fun loginUser(
       @Body login : LoginRequest
    ): LoginResponse

    //회원가입, json
    @POST("/register")
    suspend fun registerUser(
        @Body register : RegisterRequest
    ): RegisterResponse
}

