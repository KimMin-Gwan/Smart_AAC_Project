/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * -로그인 서버 응답 json 형식
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.data.model.remote

data class LoginResponse(
    val message: String,
    val status: String
)