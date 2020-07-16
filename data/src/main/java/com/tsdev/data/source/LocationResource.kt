package com.tsdev.data.source

data class LocationResource(
    val location: String,
    val detailCategoryList: List<Category>,
    val userClickedList: MutableList<Category> = mutableListOf(),
    var isExpanded: Boolean = false
)


data class Category(val categoryName: String)