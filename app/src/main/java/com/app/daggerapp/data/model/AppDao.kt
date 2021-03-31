package com.app.daggerapp.data.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(user: User)

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): List<User>

    @Query("SELECT COUNT(*) FROM users_table")
    fun getUsersCount(): Int
}