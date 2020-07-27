package com.studyship.application.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.observe
import com.studyship.application.BR
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivityCreateStudyBinding
import com.studyship.application.ui.activity.createstudy.CreateStudyStepTwoActivity
import com.studyship.application.util.comfortableStartActivity
import com.tsdev.presentation.MakeStudyViewModel
import kotlinx.android.synthetic.main.activity_create_study.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import tsthec.tsstudy.constant.SimpleClassName

class CreateStudyStepOneActivity :
    BaseActivity<MakeStudyViewModel, ActivityCreateStudyBinding>(R.layout.activity_create_study) {

    override val viewModel: MakeStudyViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind {
            setVariable(BR.vm, viewModel)
            setVariable(BR.simpleClass, SimpleClassName)
        }
        gather_date_layout.setLayoutData(listOf("일", "월", "화", "수", "목", "금", "토"))

        viewModel.moveActivityLiveData.observe(this) {
            when (it.getContentValue()) {
                SimpleClassName.SELECTED_CLASS -> {
                    comfortableStartActivity<SelectedCategoryActivity>()
                }
                SimpleClassName.PREFER_PLACE -> {
                    comfortableStartActivity<UserPreferPlaceActivity>()
                }
            }
        }

        user_level_horizontal.setLayoutData(listOf("입문", "중급", "고급", "실무", "미정"))

        user_level_horizontal.setCategoryOnClickListener = {
            Log.e("POSITION", it.toString())
        }

        user_time_horizontal.setLayoutData(listOf("오전", "오후", "저녁", "미정"))
        user_time_horizontal.setCategoryOnClickListener = {
            Log.e("POSITION", it.toString())
        }

        user_many_horizontal.setLayoutData(listOf("2명", "3명", "4명", "5명이상"))
        user_many_horizontal.setCategoryOnClickListener = {
            Log.e("POSITION", it.toString())
        }

        viewModel.moveNextStepActivity.observe(this) {
            if(it.getContentValue()) {
                comfortableStartActivity<CreateStudyStepTwoActivity>()
            }
        }
    }
}
