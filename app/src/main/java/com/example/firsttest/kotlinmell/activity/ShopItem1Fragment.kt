package com.example.firsttest.kotlinmell.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.recycleronebean
import com.example.firsttest.kotlinmell.bean.shopitembean
import com.example.firsttest.kotlinmell.bean.shoplistbean
import com.example.firsttest.kotlinmell.qingqiuti.shopitem
import com.example.firsttest.kotlinmell.qingqiuti.shoplist
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.google.gson.Gson
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_shop_item1.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ShopItem1Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_item1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        var bundle = arguments
        // val id = bundle.getString("id")
        var id: String? = bundle?.getString("id")
        Log.e("TAG", "onViewCreated: idsss" + id)
        val createServer = HttpManager.instance.createServer(HttpServer::class.java)
        if (id != null) {
            val shopitem1 = shopitem(id)
            val coroutineScope = CoroutineScope(Dispatchers.Main)
            coroutineScope.launch {
                val withContext = withContext(Dispatchers.IO) {
                    createServer.post("goods/getGoodsDetail", shopitem1)
                }
                val string = withContext.string()
                val fromJson = Gson().fromJson(string, shopitembean::class.java)
                val data = fromJson.data
                var list = data.goodsBanner.split(",")
                Log.e("TAG", "onViewCreated: idsv" + list)
                banner.setIndicatorGravity(BannerConfig.RIGHT)
                banner.setImages(list).setImageLoader(object : ImageLoader() {
                    override fun displayImage(
                        context: Context?, path: Any?, imageView: ImageView?
                    ) {
                        if (context != null) {
                            if (imageView != null) {
                                Glide.with(context).load(path).into(imageView)
                            }
                        }
                    }
                }).start()
                shopitem1title.text = data.goodsDesc
            }
        }
    }
}