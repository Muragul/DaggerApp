package com.app.daggerapp.ui.nestedrv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.R
import com.app.daggerapp.data.model.ParentModel
import kotlinx.android.synthetic.main.parent_recycler.view.*

class ParentAdapter(private val parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = parents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.bind(parent)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recyclerView: RecyclerView = itemView.rv_child
        private val textView: TextView = itemView.textView
        private val seeAllButton: Button = itemView.see_all_button

        fun bind(parent: ParentModel) {
            textView.text = parent.title
            seeAllButton.setOnClickListener {
                Log.e("Parent item: ", parent.title)
            }
            val childLayoutManager =
                LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            childLayoutManager.initialPrefetchItemCount = 4
            recyclerView.apply {
                layoutManager = childLayoutManager
                adapter = ChildAdapter(parent.children)
                setRecycledViewPool(viewPool)
            }

        }
    }
}