package com.studyship.application.ui.adapter.holder

import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerSuggestItemBinding
import com.tsdev.data.source.SuggestResponse

class SuggestRecyclerViewHolder(view: View, onClickListener: (Int) -> Unit) : BaseRecyclerViewHolder<SuggestResponse, RecyclerSuggestItemBinding>(view) {

    init {
        containerView.setOnClickListener {
            onClickListener(adapterPosition)
        }
    }
}