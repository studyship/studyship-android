package com.studyship.application.binding

import android.util.Log
import androidx.databinding.BindingAdapter
import com.tsdev.feat.widget.layout.HorizontalCategoryListView

@BindingAdapter("setListData")
fun HorizontalCategoryListView.setBindingAdapter(items: List<String>?) {
    items?.let { setCategory(it) }
}

//@BindingAdapter("setCategoryClickListener")
//fun HorizontalCategoryListView.setCategoryClickListener() {
//    setCategoryOnClickListener = {index, name ->
//        Log.e("TAG", name)
//    }
//}