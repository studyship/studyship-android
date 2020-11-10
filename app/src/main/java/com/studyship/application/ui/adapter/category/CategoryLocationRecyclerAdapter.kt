package com.studyship.application.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.category.CategoryCurrentLocationViewHolder
import com.studyship.application.ui.adapter.holder.category.CategoryDetailLocationLabelViewHolder
import com.studyship.application.ui.adapter.holder.category.CategoryLocationLabelViewHolder
import com.studyship.application.ui.adapter.holder.category.CategoryLocationListViewHolder
import tsthec.tsstudy.constant.ViewType
import tsthec.tsstudy.domain.model.DomainDetailLocation

class CategoryLocationRecyclerAdapter : BaseRecyclerViewAdapter<RecyclerItemSource.RecyclerItem>() {
    private val categoryLocationList = mutableListOf<RecyclerItemSource.RecyclerItem>()

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        if (position >= 3) {
            holder.setBindingLocationCategory(categoryLocationList[position].item as DomainDetailLocation)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            ViewType.DETAIL_LOCATION_LABEL -> {
                CategoryDetailLocationLabelViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(
                            R.layout.recycler_detail_location_label, parent,
                            false
                        )
                )
            }
            ViewType.DETAIL_LOCATION_LIST -> {
                CategoryCurrentLocationViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.recycler_detail_location, parent, false
                    )
                )
            }
            ViewType.LOCATION_BUTTON -> {
                CategoryLocationListViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_get_location_layout, parent, false)
                )
            }
            ViewType.LOCATION_LABEL -> {
                CategoryLocationLabelViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.recycler_location_label, parent, false)
                )
            }
            else -> throw IllegalAccessException("Not Found ViewType !!!")
        }
    }

    override fun getItemCount(): Int {
        return categoryLocationList.size
    }

    override fun addItem(viewType: Int, item: Any?) {
        categoryLocationList.add(RecyclerItemSource.RecyclerItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        categoryLocationList.clear()
    }

    override fun getItems(position: Int): Any? {
        return categoryLocationList[position].item
    }

    override fun destroyedPositionItem(position: Int) {
        categoryLocationList.removeAt(position)
    }

    override fun getItemViewType(position: Int): Int {
        return categoryLocationList[position].viewType
    }
}