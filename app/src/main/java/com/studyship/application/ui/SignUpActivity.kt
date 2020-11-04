package com.studyship.application.ui

import android.os.Bundle
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivitySignUpBinding
import com.tsdev.presentation.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity :
    BaseActivity<SignUpViewModel, ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override val viewModel: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind {
            vm = viewModel
            executePendingBindings()
        }
    }
}