package com.studyship.application.ui.fragment

import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMyprofileLayoutBinding
import com.tsdev.presentation.MyProfileViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyProfileFragment :
    BaseFragment<FragmentMyprofileLayoutBinding, MyProfileViewModel>(R.layout.fragment_myprofile_layout) {

    override val viewModel: MyProfileViewModel by viewModel()
}