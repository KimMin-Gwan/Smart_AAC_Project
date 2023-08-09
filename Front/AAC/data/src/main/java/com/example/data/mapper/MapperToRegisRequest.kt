package com.example.data.mapper

import com.example.data.model.remote.RegisterRequest
import com.example.domain.model.Registerrequest

fun MapperToRegisRequest (registerrequest: Registerrequest) : RegisterRequest{
    return RegisterRequest(name = registerrequest.name, phone = registerrequest.phone, password = registerrequest.password)
}