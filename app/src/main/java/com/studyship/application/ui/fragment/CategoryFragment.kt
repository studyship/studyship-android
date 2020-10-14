package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentCategoryLayoutBinding
import com.studyship.application.ext.setUpViewPager
import com.studyship.application.ui.adapter.viewpager.StudyCategoryViewPagerAdapter
import com.tsdev.presentation.StudyCategoryViewModel
import com.tsdev.presentation.base.BaseViewModel
import org.json.JSONArray
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryFragment :
    BaseFragment<FragmentCategoryLayoutBinding, StudyCategoryViewModel>(R.layout.fragment_category_layout) {

    override val viewModel: StudyCategoryViewModel by viewModel()

    private val studyCategoryAdapter: StudyCategoryViewPagerAdapter by lazy(LazyThreadSafetyMode.NONE) {
        StudyCategoryViewPagerAdapter(parentFragmentManager, this.lifecycle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {

        }

        viewDataBinding.categoryViewpager.adapter = studyCategoryAdapter

        viewDataBinding.categoryTab.setUpViewPager(
            viewDataBinding.categoryViewpager,
            studyCategoryAdapter,
            false
        )


    }
}