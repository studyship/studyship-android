package com.studyship.application.ui.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.studyship.application.data.source.RecyclerItemSource
import com.studyship.application.ext.ViewPagerResource
import com.studyship.application.ui.fragment.viewpager.*

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle), ViewPagerResource {

    private val tabNameList = mutableListOf("가입한", "내가 만든", "신청한", "북마크", "임시저장")

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MyStudyJoinFragment()
            1 -> MyStudyOwnCreateFragment()
            2 -> MyStudyAppliedFragment()
            3 -> MyStudyBookMarkFragment()
            else -> MyStudyTemporaryFragment()
        }
    }

    override fun getTitle(position: Int): String {
        return tabNameList[position]
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