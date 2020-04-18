package com.studyship.application.ui.adapter.holder

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.CategoryResponse
import com.studyship.application.databinding.RecyclerCategoryItemBinding
import com.studyship.application.ui.adapter.holder.delegate.IRecyclerDelegate

class CategoryRecyclerViewHolder(recyclerOnClick: IRecyclerDelegate, layout: View) :
    BaseRecyclerViewHolder<CategoryResponse, RecyclerCategoryItemBinding>(layout) {

    init {
        containerView.setOnClickListener {
            recyclerOnClick.onClickItem(adapterPosition)
        }
    }
}