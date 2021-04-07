package com.app.daggerapp.ui.nestedrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.R
import com.app.daggerapp.data.model.ChildModel

class ChildCategoryAdapter(private val children: List<ChildModel>) :
    RecyclerView.Adapter<ChildCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category_card, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int = children.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        holder.bind(child)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(child: ChildModel) {
        }
    }
}