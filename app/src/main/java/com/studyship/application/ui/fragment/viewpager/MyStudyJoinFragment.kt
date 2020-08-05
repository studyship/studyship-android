package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.view.View
import com.studyship.application.BR
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMyStudyJoinBinding
import com.studyship.application.ui.adapter.mystudy.MyStudyJoinRecyclerAdapter
import com.tsdev.presentation.MyStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyJoinFragment :
    BaseFragment<FragmentMyStudyJoinBinding>(R.layout.fragment_my_study_join) {

    private val viewModel by viewModel<MyStudyViewModel>()
    private val myJoinStudyAdapter: MyStudyJoinRecyclerAdapter by lazy {
        MyStudyJoinRecyclerAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.myStudyViewModel, viewModel)
            executePendingBindings()
        }

        viewDataBinding.myJoinStudyRecyclerView.run {
            adapter = myJoinStudyAdapter
        }
    }
}