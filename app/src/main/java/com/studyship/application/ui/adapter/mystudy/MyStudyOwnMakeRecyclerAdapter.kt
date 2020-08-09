package com.studyship.application.ui.adapter.mystudy

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.mystudy.MyOwnCreateStudyRecyclerViewHolder
import tsthec.tsstudy.constant.ViewType
import tsthec.tsstudy.domain.model.mystudy.response.DomainMyStudyResponse

class MyStudyOwnMakeRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {
    private val ownCreateStudy = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is MyOwnCreateStudyRecyclerViewHolder -> {
                holder.bind(ownCreateStudy[position].item as DomainMyStudyResponse)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            ViewType.OWN_CREATE_STUDY -> {
                MyOwnCreateStudyRecyclerViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_my_study_join_item, parent, false)
                )
            }
            else -> throw IllegalAccessException("You must checking viewType")
        }
    }

    override fun getItemCount(): Int = ownCreateStudy.size

    override fun addItem(viewType: Int, item: Any?) {
        ownCreateStudy.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        ownCreateStudy.clear()
    }

    override fun getItems(position: Int): Any? {
        return ownCreateStudy[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        ownCreateStudy.removeAt(position)
    }

    override fun getItemViewType(position: Int): Int {
        return ownCreateStudy[position].viewType
    }
}