package com.example.data.mapper

import com.example.data.model.remote.LoginResponse
import com.example.domain.model.Login

fun MapperToLogin(login:LoginResponse) : Login {
    return Login(message = login.message)

}
