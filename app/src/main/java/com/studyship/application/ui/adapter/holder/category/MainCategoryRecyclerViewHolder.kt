package com.studyship.application.ui.adapter.holder.category

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerMainCategoryItemBinding
import tsthec.tsstudy.domain.model.DomainMainCategory

class MainCategoryRecyclerViewHolder(view: View) :
    BaseRecyclerViewHolder<DomainMainCategory, RecyclerMainCategoryItemBinding>(view) {
    init {
    }

    fun setCustomPadding() {
        if (adapterPosition != FIRST_CHILD) {
            containerView.setPadding(0, 10, 0, 0)
        }
    }

    companion object {
        private const val FIRST_CHILD = 0
    }
}