package com.studyship.application.ui.adapter.holder

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerSuggestItemBinding
import tsthec.tsstudy.domain.model.DomainSuggestResponse

class SuggestRecyclerViewHolder(view: View, onClickListener: (Int) -> Unit) : BaseRecyclerViewHolder<DomainSuggestResponse, RecyclerSuggestItemBinding>(view) {

    init {
        containerView.setOnClickListener {
            onClickListener(adapterPosition)
        }
    }
}