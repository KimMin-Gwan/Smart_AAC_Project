package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.data.source.UserApiService
import retrofit2.Response
import javax.inject.Inject

class UserSourceImpl @Inject constructor(private val userapiInterface : UserApiService) : UserSource {
    override suspend fun getLoginUser(phone: String, password: String): List<LoginResponse> {
        return userapiInterface.loginUser(phone, password)
    }

    override suspend fun getRegisterUser(name: String, phone: String, password: String): List<RegisterResponse> {
        return userapiInterface.registerUser(name, phone, password)
    }
}