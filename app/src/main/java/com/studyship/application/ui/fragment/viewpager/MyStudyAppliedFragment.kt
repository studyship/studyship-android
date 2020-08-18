package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.util.Log
import android.view.View
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMyStudyAppliedBinding
import com.tsdev.presentation.MyStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyStudyAppliedFragment :
    BaseFragment<FragmentMyStudyAppliedBinding, MyStudyViewModel>(R.layout.fragment_my_study_applied) {

    override val viewModel: MyStudyViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            vm = viewModel
            executePendingBindings()
        }

        viewDataBinding.horizontalFilter.setCategoryOnClickListener = {
            //todo recycler Refresh
            when (it) {
                PENDING_ACCEPTANCE -> {

                }
                RECRUITING_MEMBERS -> {

                }
                WAITING -> {

                }
            }
            Log.e("CLICK", it.toString())
        }

        viewDataBinding.horizontalFilter.run {
            setLayoutData(listOf("수락대기중", "멤버모집중", "대기중"), R.layout.recycler_my_study_item)
            initSelected()
        }
    }

    companion object {
        private const val PENDING_ACCEPTANCE = 0
        private const val RECRUITING_MEMBERS = 1
        private const val WAITING = 2
    }
}