package com.example.data.source.remote

import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.data.api.UserApiService
import com.example.data.mapper.MapperToLoginRequest
import com.example.data.mapper.MapperToRegisRequest
import com.example.domain.model.Loginrequest
import com.example.domain.model.Registerrequest
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(private val userApiInterface : UserApiService) : UserDataSource {
    override suspend fun getLoginUser(loginRequest: Loginrequest): LoginResponse {
        val login = MapperToLoginRequest(loginRequest)
        return userApiInterface.loginUser(login)
    }

    override suspend fun getRegisterUser(registerRequest : Registerrequest): RegisterResponse {
        val register = MapperToRegisRequest(registerRequest)
        return userApiInterface.registerUser(register)
    }
}