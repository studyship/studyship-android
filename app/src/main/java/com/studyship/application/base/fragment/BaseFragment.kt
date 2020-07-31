package com.studyship.application.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VIEW_DATA_BINDING : ViewDataBinding>(@LayoutRes private val layout: Int) :
    Fragment() {

    protected lateinit var viewDataBinding: VIEW_DATA_BINDING
        private set



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