package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.view.View
import com.studyship.application.BR
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentOwnCreateStudyBinding
import com.tsdev.presentation.MyStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyOwnCreateFragment :
    BaseFragment<FragmentOwnCreateStudyBinding>(R.layout.fragment_own_create_study) {

    private val viewModel by viewModel<MyStudyViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {
            setVariable(BR.myStudyViewModel, viewModel)
        }
    }
}