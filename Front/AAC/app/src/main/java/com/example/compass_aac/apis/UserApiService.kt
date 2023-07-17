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

package com.example.compass_aac.apis

import com.example.compass_aac.datas.LoginResponse
import com.example.compass_aac.datas.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


//로그인
interface UserApiService {
    @FormUrlEncoded
    @POST("")
    suspend fun loginUser(
        @Field("name") name: String,
        @Field("phone") phone: String
    ): Response<LoginResponse>
}

//회원가입
interface UserRegisterApiService {
    @FormUrlEncoded
    @POST("")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("password") password :String,
    ): Response<RegisterResponse>  // Use your response type
}
