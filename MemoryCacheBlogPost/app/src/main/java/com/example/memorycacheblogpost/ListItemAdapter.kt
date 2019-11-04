package com.example.memorycacheblogpost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter : RecyclerView.Adapter<ListItemAdapter.MyViewHolder>() {

    init {
        ListItemCache.shared.setObserver {
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)

        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return ListItemCache.shared.getItems().size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = ListItemCache.shared.getItem(position)
        holder.vendor.text = "${listItem?.vendorName}"
        holder.score.text = "${listItem?.score}"
    }

    class MyViewHolder(
        val view: View,
        val vendor: TextView = view.findViewById(R.id.vendor),
        val score: TextView = view.findViewById(R.id.score)
    ) : RecyclerView.ViewHolder(view) {}
}