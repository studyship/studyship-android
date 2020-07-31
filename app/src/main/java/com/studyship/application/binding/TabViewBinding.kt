package com.studyship.application.binding

import androidx.databinding.BindingAdapter
import com.google.android.material.tabs.TabLayout

@BindingAdapter("addTabView")
fun TabLayout.setBindingTabAdapter(addItems: List<String>?) {
    addItems?.forEach {
//        addTab()
    }
}