package com.tsdev.feat.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import com.tsdev.feat.BR
import com.tsdev.feat.base.BaseRecyclerViewHolder
import com.tsdev.feat.databinding.RecyclerDateViewItemBinding

class CustomCalendarDateViewHolder(itemView: View) :
    BaseRecyclerViewHolder<RecyclerDateViewItemBinding, String>(itemView) {

    override val recyclerBinding: RecyclerDateViewItemBinding = DataBindingUtil.bind(itemView)!!

    override fun setBinding(item: String) {
        recyclerBinding.run {
            setVariable(BR.dateItem, item)
            executePendingBindings()
        }
    }
}