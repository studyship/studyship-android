package com.studyship.application.ui.adapter.holder.category

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerGetLocationLayoutBinding
import com.studyship.application.helper.Permission
import tsthec.tsstudy.domain.model.DomainDetailLocation

class CategoryLocationListViewHolder(
    view: View,
    permission: Permission,
    callback: OnRequestCallback
) :
    BaseRecyclerViewHolder<DomainDetailLocation, RecyclerGetLocationLayoutBinding>(view) {

    interface OnRequestCallback {
        fun requestCallback(permissions: Array<out String>)
    }

    init {
        recyclerBinding.location.setOnClickListener {
            permission.requestLocationPermission {
                callback.requestCallback(it)
            }
        }
    }
}