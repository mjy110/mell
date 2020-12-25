package com.example.firsttest.kotlinmell.ui.dashboard

import android.util.Log
import com.example.firsttest.kotlinmell.R
import com.example.firsttest.kotlinmell.bean.Data1
import com.example.firsttest.kotlinmell.bean.recycleronebean
import com.example.firsttest.kotlinmell.databinding.FragmentBlankBinding
import com.example.firsttest.kotlinmell.mymvvm.CategoryList
import com.example.firsttest.kotlinmell.mymvvm.MyViewModel
import com.example.firsttest.mvvmlibrary.base.BaseFragment


class BlankFragment : BaseFragment<FragmentBlankBinding,MyViewModel>() {
    // private lateinit var categoryListAdapter: CategoryListAdapter
    // private val categoryList: MutableList<CategoryList> by lazy { mutableListOf<CategoryList>() }

    override fun createLayoutId(): Int {
       return R.layout.fragment_blank
    }

    override fun initData() {
       /* mViewModel.getCateGoryList().subscribe<MutableList<CategoryList>>(
            this,mViewModel.onSuccess(),mViewModel.onError(),
            {
                Log.e("TAG", "initData: $it" )
            },{
                Log.e("TAG", "initData: $it" )
            }
        )*/
    }

}