package com.tsdev.feat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tsdev.feat.R
import com.tsdev.feat.base.BaseRecyclerViewHolder
import com.tsdev.feat.databinding.RecyclerDateViewItemBinding
import com.tsdev.feat.databinding.RecyclerDayOfWeekItemBinding
import com.tsdev.feat.util.cast
import com.tsdev.feat.viewholder.CustomCalendarDateViewHolder
import com.tsdev.feat.viewholder.CustomCalendarDayOfWeeksRecyclerViewHolder
import com.tsdev.feat.viewholder.CustomCalendarRecyclerEmptyViewHolder
import tsthec.tsstudy.constant.ViewType

sealed class RecyclerItemSource {
    data class DataSource(val viewType: Int, val item: Any) : RecyclerItemSource()
}

class CustomCalendarRecyclerAdapter : RecyclerView.Adapter<BaseRecyclerViewHolder<*, *>>() {

    private val calendarDateItems = mutableListOf<RecyclerItemSource.DataSource>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<*, *> {
        return when (viewType) {
            ViewType.DATE_OF_WEEK_VIEW -> CustomCalendarDayOfWeeksRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.recycler_day_of_week_item, parent, false
                )
            )
            ViewType.EMPTY_DATE_VIEW -> CustomCalendarRecyclerEmptyViewHolder(
                LayoutInflater.from(
                    parent.context
                ).inflate(R.layout.recycler_empty_date_view_item, parent, false)
            )
            ViewType.DATE_VIEW -> CustomCalendarDateViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_date_view_item, parent, false)
            )
            else -> throw IllegalAccessException("Illegal View Type !!!")
        }
    }

    override fun getItemCount(): Int {
        return calendarDateItems.size
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        when (holder) {
            is CustomCalendarDateViewHolder -> {
                holder.setBinding(calendarDateItems[position].item.cast())
            }
            is CustomCalendarRecyclerEmptyViewHolder -> {
                holder.setBinding(calendarDateItems[position].item.cast())
            }
            is CustomCalendarDayOfWeeksRecyclerViewHolder -> {
                holder.setBinding(calendarDateItems[position].item.cast())
            }
        }
    }

    fun addItems(items: List<RecyclerItemSource.DataSource>) {
        removeItems()
        calendarDateItems.addAll(items)
    }

    private fun removeItems() {
        calendarDateItems.clear()
    }

    override fun getItemViewType(position: Int): Int {
        return calendarDateItems[position].viewType
    }
}
