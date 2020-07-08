package com.studyship.application.base.activity

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.studyship.application.BR
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    abstract val viewModel: VM

    protected val compositeDisposable = CompositeDisposable()

    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)

    inline fun <reified DATA_BINDING : ViewDataBinding> setDataBinding(@LayoutRes layout: Int): Lazy<DATA_BINDING> =
        lazy {
            DataBindingUtil.setContentView<DATA_BINDING>(this, layout)
                .apply {
                setVariable(BR.vm, viewModel)
            }
        }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}