package com.app.daggerapp.domain

interface UserRepository {

    fun login(email: String, password: String): String
}