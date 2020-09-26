package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.view.View
import com.studyship.application.BR
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentOwnCreateStudyBinding
import com.studyship.application.ui.adapter.mystudy.MyStudyOwnMakeRecyclerAdapter
import com.tsdev.presentation.MyStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyOwnCreateFragment :
    BaseFragment<FragmentOwnCreateStudyBinding, MyStudyViewModel>(R.layout.fragment_own_create_study) {

    override val viewModel by viewModel<MyStudyViewModel>()

    private val ownCreateStudyRecyclerAdapter by lazy {
        MyStudyOwnMakeRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.myStudyViewModel, viewModel)
            executePendingBindings()
        }

        viewDataBinding.myJoinStudyRecyclerView.run {
            adapter = ownCreateStudyRecyclerAdapter
        }
    }
}