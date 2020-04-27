package com.studyship.application.base.activity

import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    abstract val viewModel: VM

    protected val compositeDisposable = CompositeDisposable()

    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}