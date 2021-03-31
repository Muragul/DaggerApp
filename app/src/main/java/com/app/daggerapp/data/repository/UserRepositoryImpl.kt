package com.app.daggerapp.data.repository

import android.util.Log
import com.app.daggerapp.data.model.AppDao
import com.app.daggerapp.data.model.User
import com.app.daggerapp.domain.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val appDao: AppDao) : UserRepository {

    override fun login(email: String, password: String): String {
        CoroutineScope(Dispatchers.IO).launch {
            val id = appDao.getUsersCount() + 1
            val user = User(id, email, password)
            appDao.addUser(user)
            Log.e("RESULT", appDao.getAllUsers().toString())
        }
        return "Success"
    }
}