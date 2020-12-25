package com.example.firsttest.kotlinmell.ui.home

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Gallery
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.firsttest.kotlinmell.*
import com.example.firsttest.kotlinmell.activity.SearchActivity
import com.example.firsttest.kotlinmell.adapter.galleryadapter
import com.example.firsttest.kotlinmell.adapter.homerecycleradapter
import com.example.qrcode.Constant
import com.example.qrcode.ScannerActivity
import com.xj.marqueeview.MarqueeView
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow
import com.example.firsttest.kotlinmell.adapter.simpletextadapter as simpletextadapter1

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
       /* homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        initView(root)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search.setOnClickListener {
            var intent=Intent(activity,SearchActivity::class.java)
            startActivity(intent)
        }
    }
    fun initView(root: View) {
        var textView: ImageView = root.findViewById(R.id.home_sao)
        textView.setOnClickListener {
            var intent = Intent(activity, ScannerActivity::class.java)
            startActivityForResult(intent, 1)
        }
        val arratImageurl = arrayListOf<String>(
            HOME_BANNER_ONE
            , HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR
        )
        var banner: Banner = root.findViewById(R.id.homebanner)
        banner.setIndicatorGravity(BannerConfig.RIGHT)
        banner.setImages(arratImageurl)
            .setImageLoader(object : ImageLoader() {
                override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                    if (context != null) {
                        if (imageView != null) {
                            Glide.with(context).load(path).into(imageView)
                        }
                    }
                }
            }).start()
        var marqueeView: MarqueeView = root.findViewById(R.id.marqueeview)
        val gonggao1 = "夏日炎炎，第一波福利还有30秒到达战场"
        val gonggao2 = "新用户立领1000元优惠券"
        val listOf = listOf(gonggao1, gonggao2)
        // simpletextadapter= simpletextadapter(activity,listOf)
        val simpletextadapter = activity?.let { simpletextadapter1(it, listOf) }
        marqueeView.setAdapter(simpletextadapter)
        var homerecycler: RecyclerView = root.findViewById(R.id.home_recycler)
        homerecycler.layoutManager =
            GridLayoutManager(activity, 1, GridLayoutManager.HORIZONTAL, false)
        val listOf1 = listOf(
            HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR,
            HOME_DISCOUNT_FIVE
        )
        homerecycler.adapter = activity?.let { homerecycleradapter(it, listOf1) }
        val listOf2 = listOf(
            HOME_TOPIC_FOUR, HOME_TOPIC_FIVE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE,
            HOME_TOPIC_FOUR
        )
        var viewpager:ViewPager=root.findViewById(R.id.viewpager)
        viewpager.adapter= activity?.let { galleryadapter(it,listOf2) }
        viewpager.currentItem=1
        viewpager.offscreenPageLimit=5
        CoverFlow.Builder().with(viewpager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==1){
            if(  grantResults.size>0&&
                grantResults[0]==PackageManager.PERMISSION_GRANTED
            ){
                var intent=Intent(activity,ScannerActivity::class.java)
                startActivityForResult(intent,1)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
           if(data==null)return
            var type: String? =data.getStringExtra(Constant.EXTRA_RESULT_CODE_TYPE)
            var content:String?=data.getStringExtra(Constant.EXTRA_RESULT_CONTENT)
        super.onActivityResult(requestCode, resultCode, data)
    }
}

