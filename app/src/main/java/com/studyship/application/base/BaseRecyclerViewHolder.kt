package com.studyship.application.base

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.studyship.application.BR
import com.studyship.application.base.cache.AndroidRecyclerViewHolder
import tsthec.tsstudy.domain.model.DomainDetailLocation
import tsthec.tsstudy.domain.model.DomainMainCategory
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse
import tsthec.tsstudy.domain.model.DomainSearchUserHistory

@Suppress("UNCHECKED_CAST")
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

    fun setBindingSearchHistory(item: DomainSearchUserHistory) {
        recyclerBinding.run {
            setVariable(BR.searchKeyword, item)
            executePendingBindings()
        }
    }

    fun setBindingMakeStudy(item: DomainMakeStudyResponse) {
        recyclerBinding.run {
            setVariable(BR.makeStudyData, item)
            executePendingBindings()
        }
    }

    fun setBindingMainCategory(item: DomainMainCategory) {
        recyclerBinding.run {
            setVariable(BR.categories, item)
            executePendingBindings()
        }
    }

    fun setBindingLocationCategory(item: DomainDetailLocation) {
        recyclerBinding.run {
            setVariable(BR.locations, item)
            executePendingBindings()
        }
    }
}