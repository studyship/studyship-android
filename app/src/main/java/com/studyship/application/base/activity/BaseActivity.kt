package com.studyship.application.base.activity

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.studyship.application.BR
import com.studyship.application.mapper.Mapper
import com.tsdev.data.source.Category
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import tsthec.tsstudy.domain.model.DomainCategory
import tsthec.tsstudy.local.settings.SEARCH_HISTORY
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    abstract val viewModel: VM

    protected val compositeDisposable = CompositeDisposable()

    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)

    protected val mapper: Mapper<DomainCategory, Category> by inject()

    inline fun <reified DATA_BINDING : ViewDataBinding> setDataBinding(@LayoutRes layout: Int): Lazy<DATA_BINDING> =
        lazy {
            DataBindingUtil.setContentView<DATA_BINDING>(this, layout)
                .apply {
                    setVariable(BR.vm, viewModel)
                    setVariable(BR.activity, this@BaseActivity)
                    lifecycleOwner = this@BaseActivity
                    executePendingBindings()
                }
        }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}