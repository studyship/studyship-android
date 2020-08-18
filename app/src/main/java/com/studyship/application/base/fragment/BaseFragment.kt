package com.studyship.application.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tsdev.presentation.base.BaseViewModel

abstract class BaseFragment<VIEW_DATA_BINDING : ViewDataBinding, VIEW_MODEL : BaseViewModel>(@LayoutRes private val layout: Int) :
    Fragment() {

    protected lateinit var viewDataBinding: VIEW_DATA_BINDING
        private set

    abstract val viewModel: VIEW_MODEL

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layout, container, false)
        return viewDataBinding.root
    }

    fun bind(valuableSetter: VIEW_DATA_BINDING.() -> Unit) {
        viewDataBinding.run(valuableSetter)
    }
}