package com.tsdev.feat.base

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewHolder<DATA_BIND : ViewDataBinding, ITEM>(layout: View) :
    RecyclerView.ViewHolder(layout) {

    abstract val recyclerBinding: DATA_BIND

    abstract fun setBinding(item: ITEM)
}