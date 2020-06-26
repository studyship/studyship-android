package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.data.CategoryResponse
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter

private const val CATEGORY_VIEW_TYPE = 2000
private const val CATEGORY_VIEW_HEADER = 1000

@BindingAdapter("categoryList", "app:setHeaderName")
fun RecyclerView.bindingAdapterCategory(list: List<CategoryResponse>?, name: String?) {
    val categoryAdapter = (this.adapter as? CategoryRecyclerAdapter)

    categoryAdapter?.addItem(CATEGORY_VIEW_HEADER, name)
    list?.takeIf { !it.isNullOrEmpty() }
        .run { categoryAdapter?.addItems(CATEGORY_VIEW_TYPE, list) }

    this.run {
        adapter = categoryAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}