package com.studyship.application.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.studyship.application.R

@BindingAdapter("temporaryStudyText")
fun TextView.setBindingTemporary(item: Int?) {
    text = if (item == 0) {
        context.getString(R.string.temporary_storage_my_study_empty)
    } else {
        context.getString(R.string.temporary_storage_my_study, item)
    }
}

@BindingAdapter("userSelectedStudyCategory")
fun TextView.setSelectedUserSelected(items: List<String>?) {
    items?.let {
        text = it.joinToString()
    } ?: let { text = context.getString(R.string.go_to_category) }
}

@BindingAdapter("userPreferStudyPlace")
fun TextView.setPreferStudyPlace(items: List<String>?) {
    items?.let {
        text = it.joinToString()
    } ?: let { text = context.getString(R.string.user_prefer_place) }
}