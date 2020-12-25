package com.example.firsttest.kotlinmell.mymvvm

import androidx.databinding.BaseObservable

data class CategoryList(
    val categoryName: String,
    val id: Int,
    val parentId: Int
): BaseObservable()