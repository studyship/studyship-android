package com.studyship.application.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.tsdev.feat.widget.layout.HorizontalCategoryListView
import tsthec.tsstudy.domain.model.DomainLocationResource

enum class CustomViewType(val viewType: Int) {
    CATEGORY(3000),

    LOCATION(3001),

    SEARCH_FILTER(3002)
}

@BindingAdapter("setListData", "callbackClickListener")
fun HorizontalCategoryListView.setBindingAdapter(
    items: List<String>?,
    categoryClickListener: (Int) -> Unit
) {
    setCategoryOnClickListener = { position: Int ->
        categoryClickListener(position)
    }

    items?.let {
        setCategory(it)
        initSelected()
    }
}

@BindingAdapter("expandedList", "customViewType")
fun RecyclerView.setBindingExpandedList(items: List<DomainLocationResource>?, viewType: Int?) {

    val bottomAdapter = adapter as? BottomSheetRecyclerAdapter

    Log.e("CATEGORY LIST", items?.toString() ?: "")
    Log.e("CATEGORY viewType", viewType?.toString() ?: "")

    when (viewType) {
        CustomViewType.CATEGORY.viewType -> {
            bottomAdapter?.destroyedEvent()
            items?.let {
                bottomAdapter?.addItems(CustomViewType.CATEGORY.viewType, it)
            }
//            bottomAdapter?.notifyItemRangeChanged(0, bottomAdapter.itemCount)
        }
        CustomViewType.LOCATION.viewType -> {
            bottomAdapter?.destroyedEvent()
            items?.let {
                bottomAdapter?.addItems(CustomViewType.LOCATION.viewType, it)
            }
//            bottomAdapter?.notifyItemRangeChanged(0, bottomAdapter.itemCount)
        }
        CustomViewType.SEARCH_FILTER.viewType -> {
            bottomAdapter?.destroyedEvent()
            items?.let {
                bottomAdapter?.addItems(CustomViewType.SEARCH_FILTER.viewType, it)
            }
//            bottomAdapter?.notifyItemRangeChanged(0, bottomAdapter.itemCount)
        }
    }

    this.run {
        adapter = bottomAdapter
        layoutManager = GridLayoutManager(context, 1)
    }
}