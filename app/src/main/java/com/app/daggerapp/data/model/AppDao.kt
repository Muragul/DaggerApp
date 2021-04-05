package com.app.daggerapp.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface AppDao {
    @Query("SELECT * FROM users_table")
    fun getAllUsersRx(): Observable<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUserRx(user: User): Completable

    @Query("SELECT COUNT(*) FROM users_table")
    fun getUsersCountRX(): Single<Int>
}