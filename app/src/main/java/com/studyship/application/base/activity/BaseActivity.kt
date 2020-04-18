package com.studyship.application.base.activity

import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseActivity : AppCompatActivity() {
    protected val compositeDisposable = CompositeDisposable()
    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)
}