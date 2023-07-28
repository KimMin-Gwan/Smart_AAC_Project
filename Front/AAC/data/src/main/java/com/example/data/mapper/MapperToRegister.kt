package com.example.data.mapper

import com.example.data.model.remote.RegisterResponse
import com.example.domain.model.Register

fun MapperToRegister(register: List<RegisterResponse>) : List<Register> {
    return register.toList().map {
        Register(
            it.message,
            it.status
        )
    }
}