package com.example.firsttest.kotlinmell.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.activity.ShopListActivity
import com.example.firsttest.kotlinmell.adapter.OneRecyclerAdapter
import com.example.firsttest.kotlinmell.adapter.TwoRecyclerAdapter
import com.example.firsttest.kotlinmell.bean.Data2
import com.example.firsttest.kotlinmell.bean.recycleronebean
import com.example.firsttest.kotlinmell.bean.recyclertwobean
import com.example.firsttest.kotlinmell.qingqiuti.recyclerone
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    lateinit var data1: List<Data2>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(root: View) {

        var LinearLayoutManager = LinearLayoutManager(activity)
        onerecycler.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        onerecycler.layoutManager = LinearLayoutManager
        tworecycler.layoutManager =
            GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        val createServer1 = HttpManager.instance.createServer(HttpServer::class.java)
        val recyclertwo = recyclerone("1")
        val coroutineScope1 = CoroutineScope(Dispatchers.Main)
        coroutineScope1.launch {
            val withcontext1 = withContext(Dispatchers.IO) {
                createServer1.post("category/getCategory", recyclertwo)
            }
            val string1 = withcontext1.string()
            val fromJson1 = Gson().fromJson(string1, recyclertwobean::class.java)
            data1 = fromJson1.data
            val adapter1= activity?.let { TwoRecyclerAdapter(it,data1) }
            tworecycler.adapter = adapter1
            adapter1!!.setOnKotlinItemClickListener(object :TwoRecyclerAdapter.IKotlinItemClickListener{
                override fun onItemClickListener(position: Int) {
                    var intent=Intent(activity, ShopListActivity::class.java)
                    intent.putExtra("id",((data1.get(position).id).toString()))
                    startActivity(intent)
                }
            })
        }
        val createServer = HttpManager.instance.createServer(HttpServer::class.java)
        val recyclerone = recyclerone("0")
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            val withcontext = withContext(Dispatchers.IO) {
                createServer.post("category/getCategory", recyclerone)
            }
            val string = withcontext.string()
            val fromJson = Gson().fromJson(string, recycleronebean::class.java)
            val data = fromJson.data
            val adapter = activity?.let { OneRecyclerAdapter(it, data) }
            onerecycler.adapter = adapter
            adapter!!.setOnKotlinItemClickListener(object :
                OneRecyclerAdapter.IKotlinItemClickListener {
                override fun onItemClickListener(position: Int) {
                    if (position == 0 || position == 1) {
                        tworecycler.visibility = View.VISIBLE
                        wenzi.visibility = View.GONE
                        val recyclertwo = recyclerone((position + 1).toString())
                        val coroutineScope1 = CoroutineScope(Dispatchers.Main)
                        coroutineScope1.launch {
                            val withcontext1 = withContext(Dispatchers.IO) {
                                createServer1.post("category/getCategory", recyclertwo)
                            }
                            val string1 = withcontext1.string()
                            val fromJson1 = Gson().fromJson(string1, recyclertwobean::class.java)
                            data1 = fromJson1.data
                            val adapter1= activity?.let { TwoRecyclerAdapter(it,data1) }
                            tworecycler.adapter = adapter1
                            adapter1!!.setOnKotlinItemClickListener(object :TwoRecyclerAdapter.IKotlinItemClickListener{
                                override fun onItemClickListener(position: Int) {
                                    var intent=Intent(activity, ShopListActivity::class.java)
                                    intent.putExtra("id",((data1.get(position).id).toString()))
                                    Log.e("TAG", "onItemClickListener:222"+ ((data1.get(position).id).toString()))
                                    startActivity(intent)
                                }
                            })
                        }
                    } else {
                        wenzi.visibility = View.VISIBLE
                        tworecycler.visibility = View.GONE
                    }
                }
            })
        }
    }
}

