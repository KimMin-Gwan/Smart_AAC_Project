package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.data.source.UserApiService
import retrofit2.Response

class UserSourceImpl(private val userapiInterface : UserApiService) : UserSource {
    override suspend fun getLoginUser(phone: Int, password: String): List<LoginResponse> {
        return userapiInterface.loginUser(phone, password)
    }

    override suspend fun getRegisterUser(name: String, phone: Int, password: String): Response<RegisterResponse> {
        return userapiInterface.registerUser(name, phone, password)
    }
}