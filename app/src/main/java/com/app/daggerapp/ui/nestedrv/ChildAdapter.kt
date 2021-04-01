package com.app.daggerapp.ui.nestedrv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.daggerapp.R
import com.app.daggerapp.data.model.ChildModel
import kotlinx.android.synthetic.main.child_recycler.view.*

class ChildAdapter(private val children: List<ChildModel>) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun getItemCount(): Int = children.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        holder.bind(child)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.child_textView
        private val imageView: ImageView = itemView.child_imageView

        fun bind(child: ChildModel) {
            imageView.setImageResource(child.image)
            textView.text = child.title
            itemView.setOnClickListener {
                Log.e("Child item: ", child.title)
            }
        }
    }
}