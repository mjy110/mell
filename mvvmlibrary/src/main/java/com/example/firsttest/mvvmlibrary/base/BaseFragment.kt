package com.example.firsttest.mvvmlibrary.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.trello.rxlifecycle2.components.support.RxFragment
import java.lang.reflect.ParameterizedType

/*
修改       确认修改
*/abstract class BaseFragment<VD : ViewDataBinding, VM : BaseViewModel> : RxFragment() {

    lateinit var mDataBind:VD
    lateinit var mViewModel:VM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBind= DataBindingUtil.inflate(inflater,createLayoutId(), container, false)
        return mDataBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val parameterizedType = this::class.java.genericSuperclass as ParameterizedType
        val vmClass:Class<VM> = parameterizedType.actualTypeArguments[1] as Class<VM>
        mViewModel= ViewModelProvider(this).get(vmClass)
        initData()
    }

    abstract fun initData()

    abstract fun createLayoutId(): Int

}