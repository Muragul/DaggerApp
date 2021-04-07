package com.app.daggerapp.ui.apollo

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.App
import com.app.daggerapp.R
import com.app.daggerapp.ui.login.MainActivity
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.activity_launch_list.*
import javax.inject.Inject

class LaunchListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val apolloViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ApolloViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContentView(R.layout.activity_launch_list)

        findViewById<ShimmerFrameLayout>(R.id.shimmerLayout).startShimmer()

        findViewById<Button>(R.id.to_main_activity).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val apollo = apolloViewModel.getListRxSingle().subscribe { it ->
            val launches = it.launches.launches.filterNotNull()
            findViewById<RecyclerView>(R.id.recycler_view).adapter = LaunchListAdapter(launches)
            findViewById<ShimmerFrameLayout>(R.id.shimmerLayout).stopShimmer()
            findViewById<ShimmerFrameLayout>(R.id.shimmerLayout).visibility = View.GONE
        }

    }
}