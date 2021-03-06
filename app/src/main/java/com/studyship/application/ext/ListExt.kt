package com.studyship.application.ext

import android.widget.TextView
import com.studyship.application.R
import tsthec.tsstudy.domain.model.DomainCategory

fun <T> MutableList<T>.containEntity(item: T) {
    if (contains(item)) {
        remove(item)
    } else {
        add(item)
    }
}

fun <T> MutableList<T>.defaultClick(item: T, textView: TextView) {
    textView.isSelected = contains(item)
}

fun MutableList<DomainCategory>.customClickListener(item: DomainCategory, textView: TextView) {
    if (contains(item)) {
        textView.text =
            textView.context.getString(R.string.user_clicked_category, item.categoryName)
    } else {
        textView.text =
            textView.context.getString(R.string.user_non_clicked_category, item.categoryName)
    }
}