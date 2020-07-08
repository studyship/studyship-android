package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import com.tsdev.feat.widget.layout.HorizontalCategoryListView

@BindingAdapter("setListData")
fun HorizontalCategoryListView.setBindingAdapter(items: List<String>?) {
    items?.let { setCategory(it) }
}