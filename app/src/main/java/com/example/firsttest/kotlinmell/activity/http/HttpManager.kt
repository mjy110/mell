package com.example.firsttest.kotlinmvp.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*

*/
class HttpManager private constructor(){
    companion object{
        val instance by lazy { HttpManager() }
        val baseurl by lazy { "http://192.168.0.187:8080/kotlin/" }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun <T> createServer(mclass:Class<T>): T {
        return getRetrofit().create(mclass)
    }
}