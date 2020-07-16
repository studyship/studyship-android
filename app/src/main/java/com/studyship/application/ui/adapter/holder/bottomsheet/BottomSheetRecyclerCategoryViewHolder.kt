package com.studyship.application.ui.adapter.holder.bottomsheet

import android.view.View
import android.widget.TextView
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerLocationItemBinding
import com.studyship.application.mapper.Mapper
import com.tsdev.data.source.Category
import com.tsdev.domain.repository.model.DomainCategory
import com.tsdev.domain.repository.model.DomainLocationResource
import kotlinx.android.synthetic.main.recycler_location_item.*
import kotlinx.android.synthetic.main.recycler_location_item.view.*

class BottomSheetRecyclerCategoryViewHolder(
    itemView: View,
    setOnClickExpandedListener: (Int, View) -> Unit,
    setOnClickCategoryClickListener: (Category, Int) -> Unit,
    setDefaultSelectedListener: (TextView, Category, Int) -> Unit,
    private val mapper: Mapper<DomainCategory, Category>
) : BaseRecyclerViewHolder<DomainLocationResource, RecyclerLocationItemBinding>(itemView) {

    init {
        containerView.category_item.setOnClickListener {
            setOnClickExpandedListener(adapterPosition, it)
        }
        containerView.expanded_menu.customCategoryClickListener = { category ->
            setOnClickCategoryClickListener(category, adapterPosition)
        }
        containerView.expanded_menu.defaultSelectedCategory = { textView, category ->
            setDefaultSelectedListener(textView, category, adapterPosition)
        }
    }

    fun setFlexibleView(items: List<DomainCategory>) {
        items.map {
            mapper.toMap(it)
        }.also { categories -> expanded_menu.setFlexItemLayout(categories) }
    }
}