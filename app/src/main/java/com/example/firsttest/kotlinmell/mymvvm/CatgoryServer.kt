package com.example.firsttest.kotlinmell.mymvvm

import com.example.firsttest.kotlinmell.bean.registbean
import com.example.firsttest.kotlinmell.bean.shoplistbean
import com.example.firsttest.kotlinmell.qingqiuti.qingqiuti
import com.example.firsttest.kotlinmell.qingqiuti.shoplist
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.example.firsttest.mvvmlibrary.base.BaseResponse

/*
修改       确认修改
*/class CatgoryServer private constructor(){
    companion object{
        val instances:CatgoryServer by lazy { CatgoryServer() }
        val httpServer:HttpServer by lazy { HttpManager.instance.createServer(HttpServer::class.java) }
    }

}