package com.example.firsttest.kotlinmell.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.loginbean
import com.example.firsttest.kotlinmell.qingqiuti.loginbb
import com.example.firsttest.kotlinmell.ui.my.MyFragment
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        regin.setOnClickListener {
            var intent = Intent(this, RegistActivity::class.java)
            startActivity(intent)
        }
        mylogin.setOnClickListener {
            val myphonenumber = myphonenumber.text.toString()
            val mypwd = mypwd.text.toString()
            val createServer = HttpManager.instance.createServer(HttpServer::class.java)
            val loginbb = loginbb(myphonenumber, "120c83f7609f61c354f", mypwd)
            val coroutineScope = CoroutineScope(Dispatchers.Main)
            coroutineScope.launch {
                val withcontext = withContext(Dispatchers.IO) {
                    createServer.post("userCenter/login", loginbb)
                }
                val string = withcontext.string()
                Log.e("TAG", "login: " + string)
                val fromJson: loginbean = Gson().fromJson(string, loginbean::class.java)
                Log.e("TAG", "login11: " + fromJson)
                if (fromJson.status == 0) {
                    Toast.makeText(this@LoginActivity, fromJson.message, Toast.LENGTH_SHORT).show()

                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, fromJson.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}