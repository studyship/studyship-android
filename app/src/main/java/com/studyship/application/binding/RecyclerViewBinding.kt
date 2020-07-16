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
import com.tsdev.domain.repository.DomainSuggestResponse
import com.tsdev.domain.repository.model.DomainCategoryResponse

@BindingAdapter("categoryList", "setHeaderName")
fun RecyclerView.bindingAdapterCategory(list: List<DomainCategoryResponse>?, name: String?) {
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
fun RecyclerView.bindingAdapterSuggest(items: List<DomainSuggestResponse>?) {
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

@BindingAdapter("saveHistory", "savePreference")
fun RecyclerView.setSaveHistoryBindingAdapter(
    searchKeyword: String?,
    savePreference: (String?) -> Unit
//    loadPreference: () -> List<String>
) {
    val searchHistoryAdapter = adapter as? SearchHistoryRecyclerAdapter

//    if (loadPreference().isNotEmpty()) {
//        loadPreference().forEach { keyword ->
//            searchHistoryAdapter?.addItem(SEARCH_HISTORY_VIEW_TYPE, keyword)
//        }
//    } else {
    searchHistoryAdapter?.addItem(SEARCH_HISTORY_VIEW_TYPE, searchKeyword)
    savePreference(searchKeyword)
//    }

    searchHistoryAdapter?.notifiedChangeItem
    this.run {
        adapter = searchHistoryAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}