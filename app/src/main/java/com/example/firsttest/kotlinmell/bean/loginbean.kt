package com.example.firsttest.kotlinmell.bean

/*
修改       确认修改
*/data class loginbean(
    val `data`: Data,
    val message: String,
    val status: Int
)

data class Data(
    val id: Int,
    val pushId: String,
    val userGender: String,
    val userIcon: String,
    val userMobile: String,
    val userName: String,
    val userSign: String
)