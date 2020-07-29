package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMystudyLayoutBinding

class MyStudyFragment :
    BaseFragment<FragmentMystudyLayoutBinding>(R.layout.fragment_mystudy_layout) {

    override lateinit var viewDataBinding: FragmentMystudyLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = onCreateViewBinding(inflater, container)

        return viewDataBinding.root
    }
}