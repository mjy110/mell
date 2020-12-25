package com.example.firsttest.kotlinmell.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.registbean
import com.example.firsttest.kotlinmell.databinding.ActivityRegistBinding
import com.example.firsttest.kotlinmell.mymvvm.MyViewModel
import com.example.firsttest.kotlinmell.qingqiuti.loginbb
import com.example.firsttest.kotlinmell.qingqiuti.qingqiuti
import com.example.firsttest.kotlinmvp.http.HttpManager
import com.example.firsttest.kotlinmvp.http.HttpServer
import com.example.firsttest.mvvmlibrary.base.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_regist.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class RegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        initView()
    }

    var a = 60
    private fun initView() {
        registcode.setOnClickListener {
            Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show()
            registcode.setBackgroundColor(Color.parseColor("#DAD8D8"))
            var timer = Timer()
            val timerTask: TimerTask = object : TimerTask() {
                override fun run() {
                    if (a == 0) {
                        runOnUiThread {
                            registcode.setText("重获验证码")
                            registcode.setTextColor(Color.parseColor("#40C4FF"))
                            registcode.setBackgroundColor(Color.parseColor("#ffffff"))
                            timer.cancel()
                        }
                    } else {
                        runOnUiThread {
                            registcode.setText(a.toString() + "s")
                            registcode.setTextColor(Color.parseColor("#ffffff"))
                        }
                        a--
                    }
                }
            }
            timer.schedule(timerTask, 1000, 1000)
        }
        registcommit.setOnClickListener {
            val registphonenumber = registphonenumber.text.toString()
            val registcode = registercode.text.toString()
            val registcommitpwd = registcommitpwd.text.toString()
            val createServer = HttpManager.instance.createServer(HttpServer::class.java)
            val regist = qingqiuti(registphonenumber, registcommitpwd, registcode)
            val coroutineScope = CoroutineScope(Dispatchers.Main)
            coroutineScope.launch {
                val withcontext = withContext(Dispatchers.IO) {
                    createServer.post("userCenter/register", regist)
                }
                val string = withcontext.string()
                val fromJson: registbean = Gson().fromJson(string, registbean::class.java)
                val status = fromJson.status
                if (status == 0) {
                    Toast.makeText(this@RegistActivity, "注册成功", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this@RegistActivity, fromJson.message, Toast.LENGTH_SHORT).show()
                }
            }
            if (registcode != "123456") {
                Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /*override fun initViewData() {
        registcommit.setOnClickListener {
            val registphonenumber = registphonenumber.text.toString()
            val registcode = registercode.text.toString()
            val registcommitpwd = registcommitpwd.text.toString()
                mViewModel.getCateGoryList1(registphonenumber, registcommitpwd,registcode).subscribe<registbean>(
                    this, mViewModel.onSuccess(), mViewModel.onError()
                    , {
                        Log.e("TAG", "initViewData: $it")
                        if (it.status == 0) {
                            Toast.makeText(this@RegistActivity, "注册成功", Toast.LENGTH_SHORT).show()
                            finish()
                        } else {
                            Toast.makeText(this@RegistActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }, {
                        Log.e("TAG", "initViewData: $it")
                    }
                )
            }
    }

    override fun createLayoutId(): Int {
        return R.layout.activity_regist
    }*/
}