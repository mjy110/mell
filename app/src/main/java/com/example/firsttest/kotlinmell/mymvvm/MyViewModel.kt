package com.example.firsttest.kotlinmell.mymvvm

import androidx.lifecycle.MutableLiveData
import com.example.firsttest.kotlinmell.qingqiuti.qingqiuti
import com.example.firsttest.kotlinmell.qingqiuti.shoplist
import com.example.firsttest.mvvmlibrary.base.BaseViewModel
import kotlinx.coroutines.launch
import java.util.*

/*
修改       确认修改
*/class MyViewModel :BaseViewModel(){
   /* fun  getCateGoryList():MyViewModel {
        requestHttp (MutableLiveData()){
            CatgoryServer.instances.postCategoryList("category/getCategory",CategoryrequestBody(0))
        }
        return this
    }*/
    //注册
  /*  fun  getCateGoryList1(name:String,pwd:String,code:String):MyViewModel {
        requestHttp(MutableLiveData()) {
            CatgoryServer.instances.postCategoryList1("userCenter/register", qingqiuti(name,pwd,code))
        }
        return this
    }*/
    //shoplist
   /* fun getshoplist(id:String):MyViewModel{
        requestHttp(MutableLiveData()) {
            CatgoryServer.instances.getshoplist("goods/getGoodsList",shoplist(id,"1"))
        }
        return this
    }*/
}