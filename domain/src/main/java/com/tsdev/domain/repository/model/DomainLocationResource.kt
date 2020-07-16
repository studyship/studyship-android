package com.tsdev.domain.repository.model

data class DomainLocationResource(
    val location: String,
    val detailCategoryList: List<DomainCategory>,
    val userClickedList: MutableList<DomainCategory> = mutableListOf(),
    var isExpanded: Boolean = false
)


data class DomainCategory(val categoryName: String)