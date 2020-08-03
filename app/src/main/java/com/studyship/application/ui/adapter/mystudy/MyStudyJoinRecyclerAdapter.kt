package com.studyship.application.ui.adapter.mystudy

import android.view.ViewGroup
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource

class MyStudyJoinRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {
    private val joinStudyList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when(holder) {

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {

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

}