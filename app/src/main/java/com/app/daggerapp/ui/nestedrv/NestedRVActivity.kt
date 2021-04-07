package com.app.daggerapp.ui.nestedrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.data.repository.ParentDataFactory
import kotlinx.android.synthetic.main.parent_recycler.*

class NestedRVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.parent_recycler)
        (application as App).appComponent.inject(this)
        shimmerLayout.startShimmer()
        initRv()
    }

    private fun initRv() {
        rvSection.adapter = ParentAdapter(ParentDataFactory.getParents(7))
        shimmerLayout.stopShimmer()
        shimmerLayout.visibility = View.GONE
    }
}