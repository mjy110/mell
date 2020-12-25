package com.example.firsttest.kotlinmell.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.Data2

/*
修改       确认修改
*/class TwoRecyclerAdapter(private val context: Context,private val list: List<Data2>):
RecyclerView.Adapter<TwoRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycleritemtwo,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.text1.setText(list.get(position).categoryName)
        Glide.with(context).load(list.get(position).categoryIcon).into(holder.image)
        holder.itemView.setOnClickListener {
            itemClickListener!!.onItemClickListener(position)
        }
    }
    class ViewHolder (itemview:View) :RecyclerView.ViewHolder(itemview){
        val image:ImageView=itemview.findViewById(R.id.itemtwoimage)
        val text1:TextView=itemview.findViewById(R.id.itemtwotext)
    }
    private var itemClickListener: IKotlinItemClickListener? = null

    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)
    }
}