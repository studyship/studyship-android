package com.studyship.application.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.studyship.application.mapper.Mapper
import com.tsdev.data.source.Category
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import org.koin.android.ext.android.inject
import tsthec.tsstudy.domain.model.DomainCategory

abstract class BaseActivity<VM : ViewModel, VIEW_BIND : ViewDataBinding>(@LayoutRes private val layout: Int) :
    AppCompatActivity() {

    protected lateinit var binding: VIEW_BIND
        private set
    protected abstract val viewModel: VM

    protected val compositeDisposable = CompositeDisposable()

    protected val backButtonBehaviorSubject = BehaviorSubject.createDefault(0L)

    protected val mapper: Mapper<DomainCategory, Category> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout)
        binding.lifecycleOwner = this
//        binding.executePendingBindings()
    }

    //    inline fun <reified DATA_BINDING : ViewDataBinding> setDataBinding(@LayoutRes layout: Int): Lazy<DATA_BINDING> =
//        lazy {
//            DataBindingUtil.setContentView<DATA_BINDING>(this, layout)
//                .apply {
//                    setVariable(BR.vm, viewModel)
//                    setVariable(BR.activity, this@BaseActivity)
//                    lifecycleOwner = this@BaseActivity
//                    executePendingBindings()
//                }
//        }
    protected fun bind(bindSet: VIEW_BIND.() -> Unit) {
        binding.run(bindSet)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }
}