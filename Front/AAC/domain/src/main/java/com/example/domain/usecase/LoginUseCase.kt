package com.example.domain.usecase

import com.example.domain.model.Login
import com.example.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(phone: String, password: String): List<Login> {
        return userRepository.loginUser(phone, password)
    }
}