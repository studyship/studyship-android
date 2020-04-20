package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.data.CategoryResponse
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter

private const val CATEGORY_VIEW_TYPE = 1000

@BindingAdapter("categoryList")
fun RecyclerView.bindingAdapterCategory(list: List<CategoryResponse>?) {
    val categoryAdapter = (this.adapter as? CategoryRecyclerAdapter)

    list?.takeIf { !it.isNullOrEmpty() }
        .apply { categoryAdapter?.addItems(CATEGORY_VIEW_TYPE, list) }

    this.run {
        adapter = categoryAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}