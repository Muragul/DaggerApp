package com.app.daggerapp.di.module

import android.app.Application
import androidx.room.Room
import com.app.daggerapp.data.model.AppDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule(application: Application) {

    private var libraryApplication = application
    private lateinit var database: AppDataBase

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDataBase {
        database =
            Room.databaseBuilder(libraryApplication, AppDataBase::class.java, "app-db")
                .fallbackToDestructiveMigration()
                .build()
        return database
    }

    @Singleton
    @Provides
    fun providesAppDao(appDataBase: AppDataBase) = appDataBase.appDao()
}