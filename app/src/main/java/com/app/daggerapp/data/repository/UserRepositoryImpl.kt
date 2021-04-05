package com.app.daggerapp.data.repository

import android.util.Log
import com.app.daggerapp.data.model.AppDao
import com.app.daggerapp.data.model.User
import com.app.daggerapp.domain.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val appDao: AppDao) : UserRepository {

    override fun login(email: String, password: String): String {
        val id = appDao.getUsersCountRX()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                val user = User(it, email, password)
                appDao.addUserRx(user)
                    .subscribeOn(Schedulers.io())
            }
        val item = appDao.getAllUsersRx()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.e("RESULT", it.toString())
            }
        return "Success"
    }
}