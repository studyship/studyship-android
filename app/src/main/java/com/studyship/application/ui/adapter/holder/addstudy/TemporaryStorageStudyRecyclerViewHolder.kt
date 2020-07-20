package com.studyship.application.ui.adapter.holder.addstudy

import android.content.Context
import android.util.Log
import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerItemTemporaryStudyBinding
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse

class TemporaryStorageStudyRecyclerViewHolder(
    view: View,
    onMoveClickListener: (Context, String) -> Unit
) : BaseRecyclerViewHolder<DomainMakeStudyResponse, RecyclerItemTemporaryStudyBinding>(view) {
    init {
        containerView.setOnClickListener {
            Log.e("ClassName", this::class.simpleName ?: "")
        }
    }
}