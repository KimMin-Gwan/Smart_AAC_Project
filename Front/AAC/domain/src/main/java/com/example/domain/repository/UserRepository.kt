package com.example.domain.repository

import com.example.domain.model.Login
import com.example.domain.model.Register

interface UserRepository {
    suspend fun loginUser(phone: Int, password: String): List<Login>

    suspend fun registerUser(name:String, phone: Int, password: String) : Register
}