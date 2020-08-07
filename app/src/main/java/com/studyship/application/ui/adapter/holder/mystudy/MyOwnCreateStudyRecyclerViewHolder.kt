package com.studyship.application.ui.adapter.holder.mystudy

import android.view.View
import com.studyship.application.BR
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerMyStudyJoinItemBinding
import tsthec.tsstudy.domain.model.mystudy.response.DomainMyStudyResponse

class MyOwnCreateStudyRecyclerViewHolder(itemView: View) :
    BaseRecyclerViewHolder<DomainMyStudyResponse, RecyclerMyStudyJoinItemBinding>(itemView) {
    fun bind(item: DomainMyStudyResponse) {
        recyclerBinding.run {
            setVariable(BR.myStudyResponse, item)
            executePendingBindings()
        }
    }
}