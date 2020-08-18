package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.view.View
import com.studyship.application.BR
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMyStudyBookmarkBinding
import com.tsdev.presentation.MyStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyBookMarkFragment :
    BaseFragment<FragmentMyStudyBookmarkBinding, MyStudyViewModel>(R.layout.fragment_my_study_bookmark) {

    override val viewModel by viewModel<MyStudyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {
            myStudyViewModel = viewModel
            executePendingBindings()
        }
    }
}