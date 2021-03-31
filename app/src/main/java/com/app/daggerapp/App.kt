package com.app.daggerapp

import android.app.Application
import com.app.daggerapp.di.AppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.create(this)
    }
}