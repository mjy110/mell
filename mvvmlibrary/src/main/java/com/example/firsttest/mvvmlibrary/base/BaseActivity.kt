package com.example.firsttest.mvvmlibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VD: ViewDataBinding,VM:BaseViewModel> : AppCompatActivity(){
    lateinit var mDataBinding:VD
    lateinit var mViewModel:VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding= DataBindingUtil.setContentView(this,createLayoutId())
        val parameterizedType = this::class.java.genericSuperclass as ParameterizedType
        val vmClass:Class<VM> = parameterizedType.actualTypeArguments[1] as Class<VM>
        mViewModel= ViewModelProvider(this).get(vmClass)
        initViewData()
    }


    abstract fun initViewData()

    abstract fun createLayoutId(): Int


}