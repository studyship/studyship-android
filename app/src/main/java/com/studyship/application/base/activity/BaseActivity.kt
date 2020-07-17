package com.studyship.application.base.activity

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.studyship.application.BR
import com.studyship.application.mapper.Mapper
import com.studyship.application.setting.SEARCH_HISTORY
import com.studyship.application.setting.StringSharedPreference
import com.tsdev.data.source.Category
import com.tsdev.domain.repository.model.DomainCategory
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BaseActivity<VM : ViewModel> : AppCompatActivity() {

    abstract val viewModel: VM

    protected val compositeDisposable = CompositeDisposable()

    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)

    protected val mapper: Mapper<DomainCategory, Category> by inject()

    protected val preference: StringSharedPreference by inject {
        parametersOf(SEARCH_HISTORY)
    }

    inline fun <reified DATA_BINDING : ViewDataBinding> setDataBinding(@LayoutRes layout: Int): Lazy<DATA_BINDING> =
        lazy {
            DataBindingUtil.setContentView<DATA_BINDING>(this, layout)
                .apply {
                    setVariable(BR.vm, viewModel)
                    setVariable(BR.activity, this@BaseActivity)
                }
        }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}