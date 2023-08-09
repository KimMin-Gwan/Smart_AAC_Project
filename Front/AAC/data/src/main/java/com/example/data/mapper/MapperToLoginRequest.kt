package com.example.data.mapper

import com.example.data.model.remote.LoginRequest
import com.example.domain.model.Loginrequest

fun MapperToLoginRequest(loginrequest: Loginrequest) : LoginRequest {
    return LoginRequest(phone = loginrequest.phone, password = loginrequest.password)
}