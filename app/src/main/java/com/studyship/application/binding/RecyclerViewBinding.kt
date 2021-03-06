package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter
import com.studyship.application.ui.adapter.MakeStudyRecyclerAdapter
import com.studyship.application.ui.adapter.SearchHistoryRecyclerAdapter
import com.studyship.application.ui.adapter.SuggestRecyclerAdapter
import com.studyship.application.ui.adapter.category.CategoryLocationRecyclerAdapter
import com.studyship.application.ui.adapter.category.CategoryMainRecyclerAdapter
import com.studyship.application.ui.adapter.mystudy.MyStudyJoinRecyclerAdapter
import com.studyship.application.ui.adapter.mystudy.MyStudyOwnMakeRecyclerAdapter
import tsthec.tsstudy.constant.ViewType
import tsthec.tsstudy.constant.ViewType.CATEGORY_VIEW_HEADER
import tsthec.tsstudy.constant.ViewType.CATEGORY_VIEW_TYPE
import tsthec.tsstudy.constant.ViewType.JOIN_STUDY
import tsthec.tsstudy.constant.ViewType.MAIN_CATEGORY_LIST
import tsthec.tsstudy.constant.ViewType.MAKE_STUDY_VIEW_TYPE
import tsthec.tsstudy.constant.ViewType.OWN_CREATE_STUDY
import tsthec.tsstudy.constant.ViewType.SEARCH_HISTORY_VIEW_TYPE
import tsthec.tsstudy.constant.ViewType.SUGGEST_VIEW_TYPE
import tsthec.tsstudy.constant.ViewType.TEMPORARY_STORAGE_STUDY
import tsthec.tsstudy.domain.model.*
import tsthec.tsstudy.domain.model.mystudy.response.DomainMyStudyResponse

private const val MAKE_STUDY_TITLE = "새로운 스터디"

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

@BindingAdapter(
    "saveHistory",
    "loadPreference",
    "isInitialized",
    "removeClickListener"
)
fun RecyclerView.setSaveHistoryBindingAdapter(
    searchKeyword: DomainSearchUserHistory?,
    loadPreference: List<DomainSearchUserHistory>?,
    initialized: Boolean,
    onClickRemoveListener: (DomainSearchUserHistory) -> Unit
) {
    val searchHistoryAdapter = adapter as? SearchHistoryRecyclerAdapter

    if (loadPreference?.isNotEmpty() == true && !initialized) {
        loadPreference.forEach { keyword ->
            searchHistoryAdapter?.addItem(SEARCH_HISTORY_VIEW_TYPE, keyword)
        }
    } else {
        if (searchKeyword != null && searchKeyword.userKeywords.isNotEmpty()) {

            if (searchHistoryAdapter?.isImplicateItem(searchKeyword.userKeywords) == true) {
                searchHistoryAdapter.setMoveItemAtFirstIndex(
                    SEARCH_HISTORY_VIEW_TYPE,
                    searchKeyword.userKeywords
                )
            } else {
                searchHistoryAdapter?.addItem(SEARCH_HISTORY_VIEW_TYPE, searchKeyword)
            }
        }
    }

    searchHistoryAdapter?.setOnClickRemoveListener = {
        onClickRemoveListener(searchHistoryAdapter?.getItems(it) as DomainSearchUserHistory)
        searchHistoryAdapter.destroyedPositionItem(it)
    }

    searchHistoryAdapter?.notifiedChangeRangeItemListener
    this.run {
        adapter = searchHistoryAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}

@BindingAdapter("makeStudyViewList")
fun RecyclerView.setMakeStudyBindingAdapter(items: List<DomainMakeStudyResponse>?) {
    val makeStudyRecyclerAdapter = adapter as? MakeStudyRecyclerAdapter

    makeStudyRecyclerAdapter?.destroyedEvent()

    items?.let {
        it.forEach { makeStudyResponse ->
            if (makeStudyResponse.title == MAKE_STUDY_TITLE) {
                makeStudyRecyclerAdapter?.addItem(MAKE_STUDY_VIEW_TYPE, makeStudyResponse)
            } else {
                makeStudyRecyclerAdapter?.addItem(TEMPORARY_STORAGE_STUDY, makeStudyResponse)
            }
        }
    }

    makeStudyRecyclerAdapter?.notifiedChangeRangeItemListener
    this.run {
        adapter = makeStudyRecyclerAdapter
    }
}

@BindingAdapter("joinStudyList")
fun RecyclerView.setJoinStudyList(items: List<DomainMyStudyResponse>?) {
    val joinMyStudyRecyclerAdapter = adapter as? MyStudyJoinRecyclerAdapter

    joinMyStudyRecyclerAdapter?.destroyedEvent()

    items?.let { responseList ->
        joinMyStudyRecyclerAdapter?.addItems(JOIN_STUDY, responseList)
    }

    joinMyStudyRecyclerAdapter?.notifiedChangeItem
    this.run {
        adapter = joinMyStudyRecyclerAdapter
    }
}

@BindingAdapter("ownMakeStudyList")
fun RecyclerView.setOwnMakeStudyList(items: List<DomainMyStudyResponse>?) {
    val ownMakeStudyRecyclerAdapter = adapter as? MyStudyOwnMakeRecyclerAdapter

    ownMakeStudyRecyclerAdapter?.destroyedEvent()

    items?.let {
        ownMakeStudyRecyclerAdapter?.addItems(OWN_CREATE_STUDY, it)
    }
    this.run {
        adapter = ownMakeStudyRecyclerAdapter
    }
}

@BindingAdapter("setOnCategoryList")
fun RecyclerView.setOnCategoryList(items: List<DomainMainCategory>?) {
    val mainCategoryRecyclerAdapter = adapter as? CategoryMainRecyclerAdapter

    mainCategoryRecyclerAdapter?.destroyedEvent()

    items?.let {
        mainCategoryRecyclerAdapter?.addItems(MAIN_CATEGORY_LIST, it)
    }

    this.run {
        adapter = mainCategoryRecyclerAdapter
    }
}

@BindingAdapter("setOnLocationList")
fun RecyclerView.setOnLocationList(items: List<DomainDetailLocation>?) {
    val categoryLocationRecyclerAdapter = adapter as? CategoryLocationRecyclerAdapter

//    categoryLocationRecyclerAdapter?.destroyedEvent()

    categoryLocationRecyclerAdapter?.addItem(ViewType.LOCATION_LABEL, "ANY")
    categoryLocationRecyclerAdapter?.addItem(ViewType.LOCATION_BUTTON, "Any")
    categoryLocationRecyclerAdapter?.addItem(ViewType.DETAIL_LOCATION_LABEL, "Any")

    items?.let {
        categoryLocationRecyclerAdapter?.addItems(ViewType.DETAIL_LOCATION_LIST, it)
    }

    this.run {
        adapter = categoryLocationRecyclerAdapter
    }
}