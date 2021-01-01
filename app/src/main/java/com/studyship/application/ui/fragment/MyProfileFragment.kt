package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.View
import com.studyship.application.R
import com.studyship.application.BR
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.base.fragment.navigate
import com.studyship.application.databinding.FragmentMyprofileLayoutBinding
import com.tsdev.presentation.MyProfileViewModel
import com.tsdev.presentation.ext.singleObserve
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyProfileFragment :
    BaseFragment<FragmentMyprofileLayoutBinding, MyProfileViewModel>(R.layout.fragment_myprofile_layout) {

    override val viewModel: MyProfileViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {
            setVariable(BR.vm, viewModel)
        }
        viewModel.navigationAction.singleObserve(viewLifecycleOwner, ::navigate)
    }
}