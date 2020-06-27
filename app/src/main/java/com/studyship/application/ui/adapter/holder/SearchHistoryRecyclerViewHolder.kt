package com.studyship.application.ui.adapter.holder

import android.util.Log
import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerSearchHistoryItemBinding
import kotlinx.android.synthetic.main.recycler_search_history_item.view.*

class SearchHistoryRecyclerViewHolder(view: View) :
    BaseRecyclerViewHolder<String, RecyclerSearchHistoryItemBinding>(view) {

    init {
        containerView.history_close_button.setOnClickListener {
            Log.e("TAG", "click")
        }
    }
}