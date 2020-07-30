package com.studyship.application.ui.adapter.holder.viewpager

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.R
import kotlinx.android.synthetic.main.recycler_view_pager_item.view.*

class MyStudyOwnCreateViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
    fun bind(item: String, tabName: String) {
//        itemView.title.text =
//            itemView.context.getString(R.string.view_pager_title_string, tabName)
        itemView.pager_item.text = item
    }
}