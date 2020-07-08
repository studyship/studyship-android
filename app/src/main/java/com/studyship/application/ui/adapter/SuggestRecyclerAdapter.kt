package com.studyship.application.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.SuggestRecyclerViewHolder

class SuggestRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {

    lateinit var onClickListener: (Int) -> Unit

    private val suggestList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is SuggestRecyclerViewHolder -> {
                holder.setBindingSuggestList(suggestList[position].item)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> =
        when (viewType) {
            SUGGEST_VIEW_TYPE -> {
                SuggestRecyclerViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.recycler_suggest_item,
                        parent,
                        false
                    ), onClickListener
                )
            }
            else -> throw IllegalAccessException()
        }


    override fun getItemCount(): Int = suggestList.size

    override fun addItem(viewType: Int, item: Any?) {
        suggestList.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach { item ->
            addItem(viewType, item)
        }
    }

    override fun destroyedEvent() {
        suggestList.clear()
    }

    override fun getItems(position: Int): Any? {
        return suggestList[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        suggestList.removeAt(position)
    }

    override fun getItemViewType(position: Int): Int {
        return suggestList[position].viewType
    }

    companion object {
        const val SUGGEST_VIEW_TYPE = 1000
    }
}