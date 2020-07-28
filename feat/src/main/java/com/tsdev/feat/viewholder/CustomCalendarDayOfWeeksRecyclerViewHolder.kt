package com.tsdev.feat.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tsdev.feat.BR
import com.tsdev.feat.base.BaseRecyclerViewHolder
import com.tsdev.feat.databinding.RecyclerDayOfWeekItemBinding

class CustomCalendarDayOfWeeksRecyclerViewHolder(itemView: View) :
    BaseRecyclerViewHolder<RecyclerDayOfWeekItemBinding, String>(itemView) {

    override val recyclerBinding: RecyclerDayOfWeekItemBinding = DataBindingUtil.bind(itemView)!!

    override fun setBinding(item: String) {
        recyclerBinding.run {
            setVariable(BR.date, item)
            executePendingBindings()
        }
    }
}