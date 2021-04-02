package com.app.daggerapp.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.ui.MapsActivity
import javax.inject.Inject

class ListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val listViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContentView(R.layout.activity_list)

        findViewById<Button>(R.id.back).setOnClickListener {
            onBackPressed()
        }

        findViewById<Button>(R.id.view_map).setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val data = listViewModel.loadDataRx().subscribe {
            Log.e("RxResult: ", it.categories.toString())
        }
    }

}