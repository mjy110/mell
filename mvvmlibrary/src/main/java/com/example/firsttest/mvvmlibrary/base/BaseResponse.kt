package com.example.firsttest.mvvmlibrary.base

/*
修改       确认修改
*/
data class BaseResponse<T> (var status:Int,var message:String,var data:T)