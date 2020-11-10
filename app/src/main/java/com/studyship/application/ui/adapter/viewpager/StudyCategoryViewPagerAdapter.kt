package com.studyship.application.ui.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.studyship.application.ext.ViewPagerResource
import com.studyship.application.ui.fragment.viewpager.category.StudyCategoryLocationFragment
import com.studyship.application.ui.fragment.viewpager.category.StudyCategoryMainFragment

class StudyCategoryViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle), ViewPagerResource {


    override fun getItemCount(): Int {
        return CATEGORIES.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> StudyCategoryMainFragment()
            1 -> StudyCategoryLocationFragment()
            else -> Fragment()
        }
    }

    companion object {
        private val CATEGORIES = listOf("카테고리", "지역", "검색필터")
    }

    override fun getTitle(position: Int): String {
        return CATEGORIES[position]
    }
}