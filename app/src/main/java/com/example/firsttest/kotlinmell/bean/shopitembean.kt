package com.example.firsttest.kotlinmell.bean

data class shopitembean(
    val data: Datas,
    val message: String,
    val status: Int
)

data class Datas(
    val categoryId: Int,
    val goodsBanner: String,
    val goodsCode: String,
    val goodsDefaultIcon: String,
    val goodsDefaultPrice: String,
    val goodsDefaultSku: String,
    val goodsDesc: String,
    val goodsDetailOne: String,
    val goodsDetailTwo: String,
    val goodsSalesCount: Int,
    val goodsSku: List<GoodsSku>,
    val goodsStockCount: Int,
    val id: Int
)

data class GoodsSku(
    val goodsId: Int,
    val goodsSkuContent: String,
    val goodsSkuTitle: String,
    val id: Int,
    val skuContent: List<String>,
    val skuTitle: String
)