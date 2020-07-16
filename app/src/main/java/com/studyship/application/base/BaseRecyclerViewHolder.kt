package com.studyship.application.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.studyship.application.BR
import com.studyship.application.base.cache.AndroidRecyclerViewHolder
import com.tsdev.data.source.Category

abstract class BaseRecyclerViewHolder<ITEM : Any?, VIEW_BINDING : ViewDataBinding>(layout: View) :
    AndroidRecyclerViewHolder(layout) {

    protected val recyclerBinding: VIEW_BINDING = DataBindingUtil.bind(layout)!!

    fun binding(item: Any?) {
        recyclerBinding.run {
            setVariable(BR.data, item as ITEM)
            executePendingBindings()
        }
    }

    fun setBindingSuggestName(item: String) {
        recyclerBinding.run {
            setVariable(BR.name, item)
            executePendingBindings()
        }
    }

    fun setBindingSuggestList(item: Any?) {
        recyclerBinding.run {
            setVariable(BR.item, item as ITEM)
            executePendingBindings()
        }
    }

    fun setBindingSearchHistory(item: String) {
        recyclerBinding.run {
            setVariable(BR.searchKeyword, item)
            executePendingBindings()
        }
    }
}