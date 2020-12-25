package com.example.firsttest.kotlinmell.bean

/*
修改       确认修改
*/data class recyclertwobean(
    val `data`: List<Data2>,
    val message: String,
    val status: Int
)

data class Data2(
    val categoryIcon: String,
    val categoryName: String,
    val id: Int,
    val parentId: Int
)