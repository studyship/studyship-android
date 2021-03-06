package com.studyship.application.ui.adapter.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.studyship.application.ext.ViewPagerResource
import com.studyship.application.ui.fragment.viewpager.category.StudyCategoryFilterFragment
import com.studyship.application.ui.fragment.viewpager.category.StudyCategoryLocationFragment
import com.studyship.application.ui.fragment.viewpager.category.StudyCategoryMainFragment

class StudyCategoryViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle), ViewPagerResource {

    override fun getItemCount(): Int {
        return CATEGORIES.size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            //todo 의문점 : 이렇게 되면 포지션에 따라 새로운 객체를 생성하나 ?
            0 -> StudyCategoryMainFragment()
            1 -> StudyCategoryLocationFragment()
            else -> StudyCategoryFilterFragment()
        }
    }

    companion object {
        private val CATEGORIES = listOf("카테고리", "지역", "검색필터")
    }

    override fun getTitle(position: Int): String {
        return CATEGORIES[position]
    }
}