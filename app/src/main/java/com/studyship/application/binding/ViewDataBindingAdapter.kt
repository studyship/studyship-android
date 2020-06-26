package com.studyship.application.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible")
fun View.setVisibleDataBindingAdapter(textLength: Int?) {
    if (textLength == 0) {
        visibility = View.VISIBLE
    } else {
        visibility = View.GONE
    }
}