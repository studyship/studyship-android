package com.studyship.application.base

import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.base.cache.IRecyclerAdapter
import com.studyship.application.base.cache.OnClickNotifiedListener
import com.studyship.application.base.cache.OnClickNotifiedPositionListener
import com.studyship.application.base.cache.OnClickNotifiedRangeListener

abstract class BaseRecyclerViewAdapter<ITEM : Any?> :
    RecyclerView.Adapter<BaseRecyclerViewHolder<*, *>>(), IRecyclerAdapter {



    override val notifiedChangeItem: OnClickNotifiedListener
        get() = {
            notifyDataSetChanged()
        }
    override val notifiedChangePositionListener: OnClickNotifiedPositionListener
        get() = {
            notifyItemChanged(it)
        }

    override val notifiedChangeRangeItemListener: OnClickNotifiedRangeListener
        get() = { fromPosition, toPosition ->
            notifyItemRangeChanged(fromPosition, toPosition)
        }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<*, *>, position: Int) {
        createBindingViewHolder(holder, position)
    }

    abstract fun createBindingViewHolder(
        holder: BaseRecyclerViewHolder<*, *>,
        position: Int
    )
}