package com.tsdev.feat.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import com.tsdev.feat.BR
import com.tsdev.feat.base.BaseRecyclerViewHolder
import com.tsdev.feat.databinding.RecyclerEmptyDateViewItemBinding

class CustomCalendarRecyclerEmptyViewHolder(itemView: View) :
    BaseRecyclerViewHolder<RecyclerEmptyDateViewItemBinding, String>(itemView) {

    override val recyclerBinding: RecyclerEmptyDateViewItemBinding =
        DataBindingUtil.bind(itemView)!!

    override fun setBinding(item: String) {
        recyclerBinding.run {
            setVariable(BR.emptyDate, item)
            executePendingBindings()
        }
    }
}