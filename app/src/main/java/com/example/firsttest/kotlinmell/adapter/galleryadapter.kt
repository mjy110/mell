package com.example.firsttest.kotlinmell.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.R
import kotlinx.android.synthetic.main.layout_topic_item.view.*

/*
修改       确认修改
*/class galleryadapter(private val context: Context,private val list:List<String>) : PagerAdapter() {
    override fun destroyItem(parent: ViewGroup, paramInt: Int, paramObject: Any) {
        parent.removeView(paramObject as View)
    }
    override fun isViewFromObject(paramView: View, paramObject: Any): Boolean {
        return paramView === paramObject
    }
    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        val rooView = LayoutInflater.from(context).inflate(R.layout.layout_topic_item, null,false)
        var itempager = rooView.itempager
        Glide.with(context).load(list.get(position)).into(itempager)
        Log.e("TAG", "instantiateItem: "+list.get(position))
        parent.addView(rooView)
        return rooView
    }
    override fun getCount(): Int {
       return this.list.size
    }

}