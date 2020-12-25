package com.example.firsttest.kotlinmell.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.activity.http.ShopItem2Fragment
import com.example.firsttest.kotlinmell.bean.shoplistbean
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_shop_item.*
import java.util.*

class ShopItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        initView()
    }
    lateinit var id:String
    private fun initView() {
        var intent = intent
        id = intent.getStringExtra("id").toString()
        Log.e("TAG", "initView: ids" + id)
        val fragment =
            ArrayList<Fragment>()
        fragment.add(ShopItem1Fragment())
        fragment.add(ShopItem2Fragment())
        var bundle = Bundle()
        bundle.putString("id", this.id)
        //ShopItem1Fragment().arguments=bundle
        Log.e("TAG", "initView: id$id")
        viewpager.setAdapter(object :
            FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment {
                fragment[position].arguments=bundle
                return fragment[position]
            }

            override fun getCount(): Int {
                return fragment.size
            }
        })
        tabalyout.setupWithViewPager(viewpager)
        tabalyout.getTabAt(0)!!.text = "商品"
        tabalyout.getTabAt(1)!!.text = "详情"
    }
}

