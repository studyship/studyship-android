package com.studyship.application.ui.adapter.holder.addstudy

import android.content.Context
import android.util.Log
import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerItemMakeStudyBinding
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse

class MakeStudyRecyclerViewHolder(view: View, onMoveClickListener: (Context, String) -> Unit) :
    BaseRecyclerViewHolder<DomainMakeStudyResponse, RecyclerItemMakeStudyBinding>(view) {
    init {
        containerView.setOnClickListener {
            Log.e("ClassName", this::class.simpleName ?: "")
            onMoveClickListener(it.context, this::class.simpleName ?: "")
        }
    }
}