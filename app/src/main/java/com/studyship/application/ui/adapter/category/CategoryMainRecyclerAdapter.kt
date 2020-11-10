package com.studyship.application.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.category.MainCategoryRecyclerViewHolder
import tsthec.tsstudy.constant.ViewType
import tsthec.tsstudy.domain.model.DomainMainCategory

class CategoryMainRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {

    private val categoryList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        holder.setBindingMainCategory(categoryList[position].item as DomainMainCategory)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            ViewType.MAIN_CATEGORY_LIST -> MainCategoryRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_main_category_item,
                    parent,
                    false
                )
            ).apply { setCustomPadding() }
            else -> throw IllegalAccessException("Not Found ViewType !!!")
        }
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun addItem(viewType: Int, item: Any?) {
        categoryList.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        categoryList.clear()
    }

    override fun getItems(position: Int): Any? {
        return categoryList[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        //no-op
    }

    override fun getItemViewType(position: Int): Int {
        return categoryList[position].viewType
    }

}