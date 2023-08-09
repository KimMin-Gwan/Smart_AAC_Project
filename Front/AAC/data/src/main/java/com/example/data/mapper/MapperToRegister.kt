package com.example.data.mapper

import com.example.data.model.remote.RegisterResponse
import com.example.domain.model.Register

fun MapperToRegister(register: RegisterResponse) : Register {
    return Register(message = register.message)
}