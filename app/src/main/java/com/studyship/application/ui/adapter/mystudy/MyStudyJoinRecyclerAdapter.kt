package com.studyship.application.ui.adapter.mystudy

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.mystudy.MyJoinStudyRecyclerViewHolder
import tsthec.tsstudy.constant.ViewType.JOIN_STUDY
import tsthec.tsstudy.domain.model.mystudy.response.DomainMyStudyResponse

class MyStudyJoinRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {
    private val joinStudyList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is MyJoinStudyRecyclerViewHolder -> {
                holder.bind(joinStudyList[position].item as DomainMyStudyResponse)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            JOIN_STUDY -> {
                MyJoinStudyRecyclerViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_my_study_join_item, parent, false)
                )
            }
            else -> throw IllegalAccessException("You Must Check viewType")
        }
    }

    override fun getItemCount(): Int {
        return joinStudyList.size
    }

    override fun addItem(viewType: Int, item: Any?) {
        joinStudyList.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        joinStudyList.clear()
    }

    override fun getItems(position: Int): Any? {
        return joinStudyList[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        joinStudyList.removeAt(position)
    }

    override fun getItemViewType(position: Int): Int {
        return joinStudyList[position].viewType
    }
}