package com.app.daggerapp.ui.apollo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.LaunchListQuery
import com.app.daggerapp.R

class LaunchListAdapter(
    private val launches: List<LaunchListQuery.Launch>
) : RecyclerView.Adapter<LaunchListAdapter.LaunchViewHolder>() {

    inner class LaunchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val site = view.findViewById<TextView>(R.id.site)
        fun bind(launch: LaunchListQuery.Launch) {
            site.text = launch.site ?: ""
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bind(launches[position])
    }

    override fun getItemCount(): Int = launches.size


}