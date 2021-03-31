package com.app.daggerapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.daggerapp.App
import com.app.daggerapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance(), "")
                .commitNow()
        }
    }

}