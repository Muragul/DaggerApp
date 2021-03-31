package com.app.daggerapp.domain

import javax.inject.Inject

class LoginUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun login(email: String, password: String) = userRepository.login(email, password)
}