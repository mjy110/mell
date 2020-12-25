package com.example.firsttest.kotlinmvp.http

import com.example.firsttest.kotlinmell.bean.registbean
import com.example.firsttest.kotlinmell.bean.shoplistbean
import com.example.firsttest.kotlinmell.mymvvm.CategoryList
import com.example.firsttest.kotlinmell.mymvvm.CategoryrequestBody
import com.example.firsttest.kotlinmell.qingqiuti.*
import com.example.firsttest.mvvmlibrary.base.BaseResponse
import okhttp3.ResponseBody
import retrofit2.http.*

/*
修改       确认修改
*/interface HttpServer {
   // @POST
   // @FormUrlEncoded
   // suspend fun post(@Url url:String,@FieldMap params:@JvmSuppressWildcards Map<String,Any>,@HeaderMap header:@JvmSuppressWildcards Map<String,Any>): ResponseBody
    @POST
    suspend fun post(@Url url:String, @Body body: qingqiuti):ResponseBody
    @POST
    suspend fun post(@Url url:String,@Body body: loginbb):ResponseBody
    @POST
    suspend fun post(@Url url:String,@Body body: recyclerone):ResponseBody
 @POST
    suspend fun post(@Url url:String,@Body body: shoplist):ResponseBody
    @POST
    suspend fun post(@Url url:String,@Body body: shopitem):ResponseBody
}