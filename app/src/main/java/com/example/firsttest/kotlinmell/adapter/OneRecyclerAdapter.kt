package com.example.firsttest.kotlinmell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.Data1

/*
修改       确认修改
*/class OneRecyclerAdapter(private val context: Context, private val list: List<Data1>) :
    RecyclerView.Adapter<OneRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.oneitemrecycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.setText(list.get(position).categoryName)
        holder.itemView.setOnClickListener {
            itemClickListener!!.onItemClickListener(position)
        }
    }

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val text: TextView = itemview.findViewById(R.id.itemtext)
    }

    private var itemClickListener: IKotlinItemClickListener? = null

    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }


    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)
    }
}