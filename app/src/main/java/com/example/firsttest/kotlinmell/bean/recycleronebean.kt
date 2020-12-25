package com.example.firsttest.kotlinmell.bean

/*
修改       确认修改
*/data class recycleronebean(
    val `data`: List<Data1>,
    val message: String,
    val status: Int
)

data class Data1(
    val categoryName: String,
    val id: Int,
    val parentId: Int
)