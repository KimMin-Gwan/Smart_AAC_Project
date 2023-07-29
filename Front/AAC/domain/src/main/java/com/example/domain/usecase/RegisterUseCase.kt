package com.example.domain.usecase

import com.example.domain.model.Register
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(name: String,phone: String, password: String): List<Register> {
        return userRepository.registerUser(name,phone, password)
    }
}