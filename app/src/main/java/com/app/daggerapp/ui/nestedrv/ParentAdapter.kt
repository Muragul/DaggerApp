package com.app.daggerapp.ui.nestedrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.R
import com.app.daggerapp.data.model.ParentModel
import kotlinx.android.synthetic.main.child_recycler.view.*
import org.w3c.dom.Text

class ParentAdapter(private val parents: List<ParentModel>) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private var mode = 1

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_recycler, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = parents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = parents[position]
        holder.bind(parent)
        mode = 3 - mode
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recyclerView: RecyclerView = itemView.rvItems
        private val section: TextView = itemView.tvSection
        private val seeAll: TextView = itemView.tvSeeAll

        fun bind(parent: ParentModel) {
            val childLayoutManager =
                LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
//            childLayoutManager.initialPrefetchItemCount = 4
            recyclerView.apply {
                layoutManager = childLayoutManager
                if (mode == 1) {
                    section.text = "Категории"
                    seeAll.text = "Все категории"
                    adapter = ChildCategoryAdapter(parent.children)
                } else
                    adapter = ChildPopularAdapter(parent.children)
                setRecycledViewPool(viewPool)
            }
        }
    }
}