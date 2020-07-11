package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.tsdev.feat.widget.layout.HorizontalCategoryListView

@BindingAdapter("setListData", "callbackClickListener")
fun HorizontalCategoryListView.setBindingAdapter(
    items: List<String>?,
    categoryClickListener: (Int) -> Unit
) {
    items?.let { setCategory(it) }

    setCategoryOnClickListener = { position: Int ->
        categoryClickListener(position)
    }
}

//@InverseBindingAdapter(attribute = "setListData", event = "callbackClickListener")
//fun HorizontalCategoryListView.getBindingAdapter(items: List<String>?): (Int) -> String {
//    return { position: Int -> items?.get(position) ?: "x" }
//}
