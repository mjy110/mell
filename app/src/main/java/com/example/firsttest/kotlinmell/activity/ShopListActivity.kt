package com.example.firsttest.kotlinmell.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.adapter.ShopListAdapter
import com.example.firsttest.kotlinmell.bean.shoplistbean
import com.example.firsttest.kotlinmell.qingqiuti.shoplist
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_shop_list.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ShopListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_list)
        initView()
    }

    lateinit var id: String
    private fun initView() {
        val intent = intent
        id = intent.getStringExtra("id").toString()
        Log.e("TAG", "initView:id " + id)
        shoplistrecycler
        // var LinearLayoutManager = LinearLayoutManager(this)
        shoplistrecycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        shoplistrecycler.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        val createServer = HttpManager.instance.createServer(HttpServer::class.java)
        val shoplist = shoplist(id, "1")
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            val withContext = withContext(Dispatchers.IO) {
                createServer.post("goods/getGoodsList", shoplist)
            }
            val toString = withContext.string()
            Log.e("TAG", "initView: 111" + toString)

            val fromJson = Gson().fromJson(toString, shoplistbean::class.java)
            val data = fromJson.data
            if (fromJson.message.equals("列表为空")) {
                qidai.visibility = View.VISIBLE
                shoplistrecycler.visibility = View.GONE
            } else {
                qidai.visibility = View.GONE
                shoplistrecycler.visibility = View.VISIBLE
                val shopListAdapter = data?.let { ShopListAdapter(this@ShopListActivity, it) }
                shoplistrecycler.adapter = shopListAdapter
                shopListAdapter!!.setOnKotlinItemClickListener(object :
                    ShopListAdapter.IKotlinItemClickListener {
                    override fun onItemClickListener(position: Int) {
                        var intent = Intent(this@ShopListActivity, ShopItemActivity::class.java)
                        intent.putExtra("id", data[position].id.toString())
                        Log.e("TAG", "onItemClickListener: idid" + data[position].id)
                        startActivity(intent)
                    }
                })
            }
        }
    }
}