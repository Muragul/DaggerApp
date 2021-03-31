package com.app.daggerapp.ui.login

import androidx.lifecycle.ViewModel
import com.app.daggerapp.domain.LoginUseCase
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    fun login(login: String, password: String) = loginUseCase.login(login, password)
}