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

package com.example.data.source

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


//사용자 정보
interface UserApiService {
    //로그인
    @FormUrlEncoded
    @POST("/login")
    suspend fun loginUser(
        @Field("phone") phone: String,
        @Field("password") password: String
    ): List<LoginResponse>

    //회원가입
    @FormUrlEncoded
    @POST("/register")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("password") password :String,
    ): List<RegisterResponse>
}

