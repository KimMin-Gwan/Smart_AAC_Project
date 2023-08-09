package com.example.data.repository

import com.example.data.mapper.MapperToLogin
import com.example.data.mapper.MapperToRegister
import com.example.data.source.remote.UserDataSource
import com.example.domain.model.Login
import com.example.domain.model.Loginrequest
import com.example.domain.model.Register
import com.example.domain.model.Registerrequest
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDataSource: UserDataSource
) : UserRepository {
    override suspend fun loginUser(loginRequest: Loginrequest): Login {
        val response = userDataSource.getLoginUser(loginRequest)
        val result = MapperToLogin(response)
       return result
    }

    override suspend fun registerUser(registerRequest : Registerrequest): Register {
        val response = userDataSource.getRegisterUser(registerRequest)
        val result = MapperToRegister(response)
        return result
    }

}