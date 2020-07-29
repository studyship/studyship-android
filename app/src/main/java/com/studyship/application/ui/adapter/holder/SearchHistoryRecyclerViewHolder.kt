package com.studyship.application.ui.adapter.holder

import android.util.Log
import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerSearchHistoryItemBinding
import com.tsdev.data.source.UserSearchHistory
import kotlinx.android.synthetic.main.recycler_search_history_item.view.*

class SearchHistoryRecyclerViewHolder(
    view: View,
    setOnClickRemoveListener: SetOnClickRemoveListener,
    setOnClickFocusListener: SetOnClickFocusListener
) :
    BaseRecyclerViewHolder<UserSearchHistory, RecyclerSearchHistoryItemBinding>(view) {

    init {
        containerView.history_close_button.setOnClickListener {
            Log.e("TAG", adapterPosition.toString())
            setOnClickRemoveListener(adapterPosition)
        }

        containerView.keyword.setOnClickListener {
            setOnClickFocusListener(adapterPosition)
        }
    }
}

typealias SetOnClickRemoveListener = (Int) -> Unit
typealias SetOnClickFocusListener = (Int) -> Unit