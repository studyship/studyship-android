package com.studyship.application.ui.fragment.viewpager

import android.os.Bundle
import android.util.Log
import android.view.View
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentMyStudyAppliedBinding

class MyStudyAppliedFragment :
    BaseFragment<FragmentMyStudyAppliedBinding>(R.layout.fragment_my_study_applied) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind {

        }

        viewDataBinding.horizontalFilter.setCategoryOnClickListener = {
            //todo recycler Refresh
            Log.e("CLICK", it.toString())
        }

        viewDataBinding.horizontalFilter.run {
            setLayoutData(listOf("수락대기중", "멤버모집중", "대기중"), R.layout.recycler_my_study_item)
            initSelected()
        }
    }
}