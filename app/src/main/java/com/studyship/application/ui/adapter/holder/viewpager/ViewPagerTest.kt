package com.studyship.application.ui.adapter.holder.viewpager

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_pager_item.view.*

class ViewPagerTest(layout: View) : RecyclerView.ViewHolder(layout) {
    fun bind(item : String) {
        itemView.pager_item.text = item
    }
}