package com.example.domain.usecase

import com.example.domain.model.Register
import com.example.domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(name: String,phone: String, password: String): List<Register> {
        return userRepository.registerUser(name,phone, password)
    }
}