package com.example.domain.usecase

import com.example.domain.model.Register
import com.example.domain.model.Registerrequest
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(registerRequest : Registerrequest): Register {
        return userRepository.registerUser(registerRequest)
    }
}