package com.studyship.application.ui.adapter.holder

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerSuggestItemBinding
import com.tsdev.domain.repository.DomainSuggestResponse

class SuggestRecyclerViewHolder(view: View, onClickListener: (Int) -> Unit) : BaseRecyclerViewHolder<DomainSuggestResponse, RecyclerSuggestItemBinding>(view) {

    init {
        containerView.setOnClickListener {
            onClickListener(adapterPosition)
        }
    }
}