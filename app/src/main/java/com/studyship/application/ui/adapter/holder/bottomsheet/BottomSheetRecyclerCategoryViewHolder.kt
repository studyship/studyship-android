package com.studyship.application.ui.adapter.holder.bottomsheet

import android.util.Log
import android.view.View
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.databinding.RecyclerLocationItemBinding
import com.tsdev.data.source.Category
import com.tsdev.data.source.LocationResource
import kotlinx.android.synthetic.main.recycler_location_item.*
import kotlinx.android.synthetic.main.recycler_location_item.view.*

class BottomSheetRecyclerCategoryViewHolder(
    itemView: View,
    setOnClickExpandedListener: (Int) -> Unit
) : BaseRecyclerViewHolder<LocationResource, RecyclerLocationItemBinding>(itemView) {

    init {
        containerView.imageView7.setOnClickListener {
            setOnClickExpandedListener(adapterPosition)
        }
    }

    fun setFlexibleView(items: List<Category>) {
        Log.e("CATEGORY", items.toString())
        expanded_menu.setFlexItemLayout(items)
    }
}