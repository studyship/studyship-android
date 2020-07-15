package com.studyship.application.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studyship.application.R
import com.studyship.application.base.BaseRecyclerViewAdapter
import com.studyship.application.base.BaseRecyclerViewHolder
import com.studyship.application.ui.adapter.holder.bottomsheet.BottomSheetRecyclerCategoryViewHolder
import com.studyship.application.ui.adapter.source.BottomSheetSource
import com.tsdev.data.source.LocationResource
import java.lang.IllegalArgumentException

class BottomSheetRecyclerAdapter : BaseRecyclerViewAdapter<BottomSheetSource.BottomSheetItem>() {

    private val bottomSheetItem = mutableListOf<BottomSheetSource.BottomSheetItem>()

    lateinit var hideKeyBoard: () -> Unit

    private val expandedClickListener: (Int, View) -> Unit = { position, view ->
        (bottomSheetItem[position].data as? LocationResource)?.isExpanded =
            (bottomSheetItem[position].data as? LocationResource)?.isExpanded != true

        Log.e(
            "CLICKED",
            (bottomSheetItem[position].data as? LocationResource)?.isExpanded.toString()
        )
        view.isSelected = (bottomSheetItem[position].data as? LocationResource)?.isExpanded == true

        if (::hideKeyBoard.isInitialized) {
            hideKeyBoard()
        }
        notifyDataSetChanged()
    }

    override fun createBindingViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is BottomSheetRecyclerCategoryViewHolder -> {
                holder.setFlexibleView((bottomSheetItem[position].data as LocationResource).detailCategoryList)
                holder.binding(bottomSheetItem[position].data)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            CATEGORY -> {
                BottomSheetRecyclerCategoryViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.recycler_location_item,
                        parent,
                        false
                    ), expandedClickListener
                )
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return bottomSheetItem.size
    }

    override fun addItem(viewType: Int, item: Any?) {
        bottomSheetItem.add(BottomSheetSource.BottomSheetItem(viewType, item))
    }

    override fun addItems(viewType: Int, itemList: List<Any>?) {
        itemList?.forEach {
            addItem(viewType, it)
        }
    }

    override fun destroyedEvent() {
        bottomSheetItem.clear()
    }

    override fun getItems(position: Int): Any? {
        return bottomSheetItem[position]
    }

    override fun destroyedPositionItem(position: Int) {
        bottomSheetItem.removeAt(position)
    }

    override fun getItemViewType(position: Int): Int {
        return bottomSheetItem[position].viewType
    }

    companion object {
        private const val CATEGORY = 3000

        private const val LOCATION = 3001

        private const val SEARCH_FILTER = 3002
    }
}