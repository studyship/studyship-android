package com.studyship.application.ui.adapter.holder

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerCategoryItemBinding
import com.studyship.application.ui.adapter.holder.delegate.IRecyclerDelegate
import com.tsdev.domain.repository.model.DomainCategoryResponse
import kotlinx.android.synthetic.main.recycler_category_item.view.*

class CategoryRecyclerViewHolder(recyclerOnClick: IRecyclerDelegate, layout: View) :
    BaseRecyclerViewHolder<DomainCategoryResponse, RecyclerCategoryItemBinding>(layout) {

    init {
        containerView.setOnClickListener {
            recyclerOnClick.onClickItem(
                adapterPosition,
                containerView.item_poster_transformationLayout
            )
        }
        containerView.category_list.setCategoryData(listOf("UXUI", "프론트앤드", "포트폴리오"))
    }
}