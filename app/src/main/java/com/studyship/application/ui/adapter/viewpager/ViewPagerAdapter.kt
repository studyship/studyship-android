package com.studyship.application.ui.adapter.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.studyship.application.R
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ui.adapter.holder.viewpager.MyStudyJoinRecyclerViewHolder
import com.studyship.application.ui.adapter.holder.viewpager.MyStudyOwnCreateViewHolder
import tsthec.tsstudy.constant.ViewType

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val tabNameList = mutableListOf("가입한", "내가 만든", "신청한", "북마크", "임시저장")

    private val viewItemList = mutableListOf<RecyclerItemSource.RecyclerItem>()
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        when (position) {

        }
    }

//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): RecyclerView.ViewHolder {
//        return when (viewType) {
//            ViewType.JOIN_STUDY -> {
//                MyStudyJoinRecyclerViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.recycler_view_pager_item, parent, false)
//                )
//            }
//            ViewType.OWN_CREATE_STUDY -> {
//                MyStudyOwnCreateViewHolder(
//                    LayoutInflater.from(parent.context)
//                        .inflate(R.layout.recycler_view_pager_item, parent, false)
//                )
//            }
//            else -> throw IllegalAccessException("UNKNOWN ViewType!")
//        }
//    }
//
//    override fun getItemCount(): Int = 5
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder) {
//            is MyStudyJoinRecyclerViewHolder -> {
//                holder.bind(
//                    "Here is $position Position View",
//                    tabNameList[position]
//                )
//            }
//            is MyStudyOwnCreateViewHolder -> {
//                holder.bind(
//                    "Here is $position Position View",
//                    tabNameList[position]
//                )
//            }
//        }
//    }
//
//    private fun addItem(viewType: Int, item: Any?) {
//        viewItemList.add(RecyclerItemSource.RecyclerItem(viewType, item))
//    }
//
//    fun replaceAll(viewType: Int, item: List<Any>?) {
//        viewItemList.clear()
//        item?.forEach { it ->
//            addItem(viewType, it)
//        }
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return viewItemList[position].viewType
//    }
}