package com.studyship.application.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.constant.ViewType.CATEGORY_VIEW_HEADER
import com.studyship.application.constant.ViewType.CATEGORY_VIEW_TYPE
import com.studyship.application.constant.ViewType.SEARCH_HISTORY_VIEW_TYPE
import com.studyship.application.constant.ViewType.SUGGEST_VIEW_TYPE
import com.studyship.application.data.CategoryResponse
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter
import com.studyship.application.ui.adapter.SearchHistoryRecyclerAdapter
import com.studyship.application.ui.adapter.SuggestRecyclerAdapter
import com.tsdev.data.source.SuggestResponse

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

@BindingAdapter("setSuggestList")
fun RecyclerView.bindingAdapterSuggest(items: List<SuggestResponse>?) {
    val suggestAdapter = adapter as? SuggestRecyclerAdapter

    items?.takeIf { !it.isNullOrEmpty() }
        .run { suggestAdapter?.addItems(SUGGEST_VIEW_TYPE, items) }

    this.run {
        adapter = suggestAdapter
        layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }
    }
}

@BindingAdapter("bind:saveHistory")
fun RecyclerView.setSaveHistoryBindingAdapter(
    searchKeyword: String?
) {
    Log.e("ㅗㅑ", searchKeyword ?: "N/A")
    val searchHistoryAdapter = adapter as? SearchHistoryRecyclerAdapter

    searchHistoryAdapter?.addItem(SEARCH_HISTORY_VIEW_TYPE, searchKeyword)

    searchHistoryAdapter?.notifiedChangeItem
    this.run {
        adapter = searchHistoryAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}