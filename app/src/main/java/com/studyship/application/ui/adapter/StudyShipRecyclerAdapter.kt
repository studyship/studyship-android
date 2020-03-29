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

class CategoryRecyclerAdapter :
    BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem, RecyclerCategoryItemBinding>() {

    companion object {
        const val CATEGORY_VIEW_TYPE = 1000
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, RecyclerCategoryItemBinding> =
        when (viewType) {
            CATEGORY_VIEW_TYPE -> CategoryRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_category_item,
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
        holder: BaseRecyclerViewHolder<*, RecyclerCategoryItemBinding>,
        position: Int
    ) {
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