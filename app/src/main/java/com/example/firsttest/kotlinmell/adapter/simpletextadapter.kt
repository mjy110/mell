package com.example.firsttest.kotlinmell.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.firsttest.kotlinmell.R
import com.xj.marqueeview.base.CommonAdapter
import com.xj.marqueeview.base.ViewHolder
import java.util.*

internal class simpletextadapter(
    private val context1: Context,
    datas: List<String>
) :
    CommonAdapter<String?>(context1, R.layout.simple_text, datas) {
    override fun convert(viewHolder: ViewHolder?, item: String?, position: Int) {
        val tv = viewHolder!!.getView<TextView>(R.id.tv)
        tv.text = datas[position]
    }
}