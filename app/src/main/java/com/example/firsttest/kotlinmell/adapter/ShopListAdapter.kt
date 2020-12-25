package com.example.firsttest.kotlinmell.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.shoplistbean


/*
修改       确认修改
*/class ShopListAdapter(private val context: Context, private val list:List<shoplistbean.DataBean>):
    RecyclerView.Adapter<ShopListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.shoplistitem,parent,false)
        return ShopListAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(list.get(position).goodsDefaultIcon).into(holder.image)
        holder.title.setText(list[position].goodsDesc)
        holder.kucun.setText("库存"+list[position].goodsStockCount)
        holder.num.setText("销量"+list.get(position).goodsSalesCount+"件")
        holder.itemView.setOnClickListener {
            itemClickListener!!.onItemClickListener(position)
        }
    }
    class ViewHolder (itemview:View) :RecyclerView.ViewHolder(itemview){
        val image: ImageView =itemview.findViewById(R.id.shoplistitemimage)
        val title: TextView =itemview.findViewById(R.id.shoplistitemtitle)
        val kucun: TextView =itemview.findViewById(R.id.kucun)
        val num: TextView =itemview.findViewById(R.id.num)
    }
    private var itemClickListener: IKotlinItemClickListener? = null

    fun setOnKotlinItemClickListener(itemClickListener: IKotlinItemClickListener) {
        this.itemClickListener = itemClickListener
    }


    interface IKotlinItemClickListener {
        fun onItemClickListener(position: Int)
    }
}