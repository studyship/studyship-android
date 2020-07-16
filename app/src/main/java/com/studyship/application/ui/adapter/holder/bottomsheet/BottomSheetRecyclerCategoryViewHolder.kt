package com.studyship.application.ui.adapter.holder.bottomsheet

import android.view.View
import android.widget.TextView
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerLocationItemBinding
import com.tsdev.data.source.Category
import com.tsdev.domain.repository.model.DomainLocationResource
import kotlinx.android.synthetic.main.recycler_location_item.*
import kotlinx.android.synthetic.main.recycler_location_item.view.*

class BottomSheetRecyclerCategoryViewHolder(
    itemView: View,
    setOnClickExpandedListener: (Int, View) -> Unit,
    setOnClickCategoryClickListener: (Category, Int) -> Unit,
    setDefaultSelectedListener: (TextView, Category, Int) -> Unit
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

    fun setFlexibleView(items: List<Category>) {
        expanded_menu.setFlexItemLayout(items)
    }
}