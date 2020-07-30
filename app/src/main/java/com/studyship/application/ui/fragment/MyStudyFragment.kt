package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMystudyLayoutBinding
import com.studyship.application.ui.adapter.viewpager.ViewPagerAdapter

class MyStudyFragment :
    BaseFragment<FragmentMystudyLayoutBinding>(R.layout.fragment_mystudy_layout) {

    private val nameList = listOf("가입한", "내가 만든", "신청한", "북마크", "임시저장")
    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter(this.requireActivity())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.run {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }

        viewDataBinding.myStudyViewPager.adapter = viewPagerAdapter

        TabLayoutMediator(
            viewDataBinding.tabLayout,
            viewDataBinding.myStudyViewPager
        ) { tab, position ->
            tab.text = nameList[position]
        }.attach()
    }

}