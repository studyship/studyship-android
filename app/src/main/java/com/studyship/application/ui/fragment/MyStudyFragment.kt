package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMystudyLayoutBinding
import com.studyship.application.ext.ViewPagerResource
import com.studyship.application.ext.setUpViewPager
import com.studyship.application.ui.adapter.viewpager.ViewPagerAdapter
import com.tsdev.presentation.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyFragment :
    BaseFragment<FragmentMystudyLayoutBinding, BaseViewModel>(R.layout.fragment_mystudy_layout) {
    override val viewModel: BaseViewModel by viewModel()
    private val nameList = listOf("가입한", "내가 만든", "신청한", "북마크", "임시저장")
    private val viewPagerAdapter: ViewPagerAdapter by lazy {
        ViewPagerAdapter(childFragmentManager, lifecycle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewDataBinding.run {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }

        viewDataBinding.myStudyViewPager.adapter = viewPagerAdapter

        viewDataBinding.tabLayout.setUpViewPager(viewDataBinding.myStudyViewPager, viewPagerAdapter, true)
    }

}