package com.example.data.mapper

import com.example.data.api.Key
import com.example.domain.model.KeyParam

fun MapperToKeyParam(keyParam: KeyParam) :Key {
    return Key(keyParam.key)
}