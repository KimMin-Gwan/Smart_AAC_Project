package com.example.domain.repository

import com.example.domain.model.Login
import com.example.domain.model.Loginrequest
import com.example.domain.model.Register
import com.example.domain.model.Registerrequest

interface UserRepository {
    suspend fun loginUser(loginRequest: Loginrequest): Login

    suspend fun registerUser(registerRequest : Registerrequest) : Register
}