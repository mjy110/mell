package com.example.firsttest.kotlinmell.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.R


/*
修改       确认修改
*/
class homerecycleradapter (private val context: Context,private val list: List<String>):
    Adapter<homerecycleradapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): homerecycleradapter.ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.homritem,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: homerecycleradapter.ViewHolder, position: Int) {
        Glide.with(context).load(list[position]).into(holder.image)
    }
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.homeitemimage)
    }
}