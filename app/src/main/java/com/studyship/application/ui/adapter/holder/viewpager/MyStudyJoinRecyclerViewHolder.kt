package com.studyship.application.ui.adapter.holder.viewpager

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.R
import kotlinx.android.synthetic.main.recycler_view_pager_item.view.*

class MyStudyJoinRecyclerViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
    fun bind(item: String, tabName: String) {
        itemView.title.text =
            itemView.context.getString(R.string.view_pager_title_string, tabName)

//        if (tabName == "신청한") {
//            itemView.title.visibility = View.GONE
//            itemView.horizontal_list_filter.visibility = View.VISIBLE
//            itemView.horizontal_list_filter.setLayoutData(
//                filterNames,
//                R.layout.recycler_my_study_item
//            )
//            itemView.horizontal_list_filter.setCategoryOnClickListener = {
//                Log.e("CLICK", it.toString())
//            }
//            itemView.horizontal_list_filter.initSelected()
//        } else {
//            itemView.title.visibility = View.VISIBLE
//            itemView.horizontal_list_filter.visibility = View.GONE
//        }
        itemView.pager_item.text = item
    }
}