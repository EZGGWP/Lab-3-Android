package com.itmo.lab3belov

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(context: Context, private val android: List<TileData>, private val listener: (position: Int) -> Unit): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_tile, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = android.size

    private fun getItem(position: Int): TileData = android[position]

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val image: ImageView = itemView.findViewById(R.id.image)
        private val title: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(version: TileData) {
            image.setImageResource(version.imageAndroid)
            title.text = version.title
        }

        override fun onClick(v: View?) {
            listener.invoke(adapterPosition);
        }
    }
}