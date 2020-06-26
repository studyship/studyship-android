package com.studyship.application.ui.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.databinding.RecyclerCategoryItemBinding
import com.studyship.application.ui.adapter.holder.CategoryRecyclerViewHolder
import com.studyship.application.ui.adapter.holder.CategoryRecyclerViewHolderHeader
import com.studyship.application.ui.adapter.holder.delegate.IRecyclerDelegate

class CategoryRecyclerAdapter(private val recyclerDelegate: IRecyclerDelegate) :
    BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {

    private val recyclerList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    companion object {
        const val CATEGORY_VIEW_TYPE = 2000

        const val HEADER_VIEW_TYPE = 1000
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> =
        when (viewType) {
            CATEGORY_VIEW_TYPE -> CategoryRecyclerViewHolder(
                recyclerDelegate,
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_category_item,
                    parent,
                    false
                )
            )
            HEADER_VIEW_TYPE -> CategoryRecyclerViewHolderHeader(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_category_header,
                    parent,
                    false
                )
            )
            else -> throw Resources.NotFoundException("Not set view type")
        }


    override fun getItemCount(): Int = recyclerList.size

    override fun addItem(viewType: Int, item: Any?) {
        recyclerList.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun createBindingViewHolder(
        holder: BaseRecyclerViewHolder<*, *>,
        position: Int
    ) {
        when (holder) {
            is CategoryRecyclerViewHolder -> {
                holder.binding(recyclerList[position].item)
            }
            is CategoryRecyclerViewHolderHeader -> {
                holder.setBindingSuggestName("홍길동")
            }
        }
        holder.run {
            binding(recyclerList[position].item)
        }
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach { item ->
            addItem(viewType, item)
        }
    }

    override fun destroyedEvent() {
        recyclerList.clear()
    }

    override fun getItemViewType(position: Int): Int =
        recyclerList[position].viewType
}