package com.app.daggerapp.ui.nestedrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.data.repository.ParentDataFactory
import kotlinx.android.synthetic.main.activity_nested_r_v.*

class NestedRVActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_r_v)
        (application as App).appComponent.inject(this)

        initRecycler()
    }

    private fun initRecycler() {
        recyclerView = rv_parent
        recyclerView.adapter = ParentAdapter(ParentDataFactory.getParents(40))
    }
}