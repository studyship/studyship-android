package com.studyship.application.ui.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivitySplash2Binding
import com.studyship.application.ui.activity.MainActivity
import com.studyship.application.util.comfortableStartActivity
import com.tsdev.presentation.SplashViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity :
    BaseActivity<SplashViewModel, ActivitySplash2Binding>(R.layout.activity_splash2) {

    override val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind {
            vm = viewModel
            executePendingBindings()
        }

        viewModel.splashCallback.observe(this, Observer {
            if (it.getContentValue()) {
                comfortableStartActivity<MainActivity>()
            }
        })
    }
}