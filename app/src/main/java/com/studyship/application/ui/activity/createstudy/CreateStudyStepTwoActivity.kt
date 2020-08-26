package com.studyship.application.ui.activity.createstudy

import android.os.Bundle
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivityCreateStudyStepTwoBinding
import com.tsdev.presentation.MakeStudyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateStudyStepTwoActivity :
    BaseActivity<MakeStudyViewModel, ActivityCreateStudyStepTwoBinding>(R.layout.activity_create_study_step_two) {

    override val viewModel: MakeStudyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}