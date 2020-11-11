package com.studyship.application.ui.fragment.viewpager.category

import android.os.Bundle
import android.view.View
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentCategoryLocationBinding
import com.studyship.application.ui.adapter.category.CategoryLocationRecyclerAdapter
import com.studyship.application.ui.decoration.CategoryLocationDecoration
import com.tsdev.presentation.CategoryLocationViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudyCategoryLocationFragment :
    BaseFragment<FragmentCategoryLocationBinding, CategoryLocationViewModel>(R.layout.fragment_category_location) {

    override val viewModel: CategoryLocationViewModel by viewModel()

    private val categoryLocationRecyclerAdapter: CategoryLocationRecyclerAdapter by lazy {
        CategoryLocationRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            vm = viewModel
        }

        viewDataBinding.categoryLocation.run {
            adapter = categoryLocationRecyclerAdapter
            addItemDecoration(CategoryLocationDecoration(this@StudyCategoryLocationFragment.requireActivity()))
        }
    }
}