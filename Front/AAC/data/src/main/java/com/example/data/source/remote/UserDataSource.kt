package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.domain.model.Loginrequest
import com.example.domain.model.Registerrequest

interface UserDataSource {
    suspend fun getLoginUser(
        loginRequest: Loginrequest
    ) : LoginResponse

    suspend fun getRegisterUser(
        registerRequest : Registerrequest
    ) :RegisterResponse
}