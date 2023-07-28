package com.example.data.repository

import com.example.data.mapper.MapperToLogin
import com.example.data.mapper.MapperToRegister
import com.example.data.model.remote.LoginResponse
import com.example.data.model.remote.RegisterResponse
import com.example.data.source.UserApiService
import com.example.data.source.remote.UserSource
import com.example.domain.model.Login
import com.example.domain.model.Register
import com.example.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userdatasource: UserSource
) : UserRepository {
    override suspend fun loginUser(phone: String, password: String): List<Login> {
        val response = userdatasource.getLoginUser(phone, password)
        val result = MapperToLogin(response)
       return result
    }

    override suspend fun registerUser(name: String, phone: String, password: String): List<Register> {
        val response = userdatasource.getRegisterUser(name, phone, password)
        val result = MapperToRegister(response)
        return result
    }

}