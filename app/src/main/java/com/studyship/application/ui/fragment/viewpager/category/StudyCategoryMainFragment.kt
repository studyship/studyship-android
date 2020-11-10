package com.studyship.application.ui.fragment.viewpager.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentCategoryMainBinding
import com.studyship.application.ui.adapter.category.CategoryMainRecyclerAdapter
import com.studyship.application.ui.decoration.MainCategoryDecoration
import com.tsdev.presentation.CategoryMainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudyCategoryMainFragment :
    BaseFragment<FragmentCategoryMainBinding, CategoryMainViewModel>(R.layout.fragment_category_main) {

    override val viewModel: CategoryMainViewModel by viewModel()

    private val categoryMainRecyclerAdapter by lazy {
        CategoryMainRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            vm = viewModel
        }

        viewDataBinding.mainCategory.run {
            adapter = categoryMainRecyclerAdapter
            addItemDecoration(MainCategoryDecoration(40))
        }
    }
}