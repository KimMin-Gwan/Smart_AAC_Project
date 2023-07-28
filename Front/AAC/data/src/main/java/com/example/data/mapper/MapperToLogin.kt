package com.example.data.mapper

import com.example.data.model.remote.LoginResponse
import com.example.domain.model.Login

fun MapperToLogin(login:List<LoginResponse>) : List<Login> {
    return login.toList().map {
        Login(
            it.message,
            it.status
        )
    }
}