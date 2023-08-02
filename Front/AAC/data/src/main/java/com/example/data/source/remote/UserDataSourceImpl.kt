package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.data.api.UserApiService
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val userApiInterface : UserApiService) : UserDataSource {
    override suspend fun getLoginUser(phone: String, password: String): List<LoginResponse> {
        return userApiInterface.loginUser(phone, password)
    }

    override suspend fun getRegisterUser(name: String, phone: String, password: String): List<RegisterResponse> {
        return userApiInterface.registerUser(name, phone, password)
    }
}