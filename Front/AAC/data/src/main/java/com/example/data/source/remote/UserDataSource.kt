package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse

interface UserDataSource {
    suspend fun getLoginUser(
        phone : String,
        password: String
    ) : List<LoginResponse>

    suspend fun getRegisterUser(
        name : String,
        phone: String,
        password: String
    ) : List<RegisterResponse>
}