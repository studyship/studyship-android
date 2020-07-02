package com.studyship.application.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible")
fun View.setVisibleDataBindingAdapter(textLength: Int?) {
    visibility = if (textLength == 0) {
        View.VISIBLE
    } else {
        View.GONE
    }

}

@BindingAdapter("app:getInputText")
fun View.setInVisibleBindingAdapter(userInputText: String?) {
    visibility = if(userInputText.isNullOrEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}