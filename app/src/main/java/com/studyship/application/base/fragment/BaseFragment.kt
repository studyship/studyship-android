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

    abstract var viewDataBinding: VIEW_DATA_BINDING

    fun onCreateViewBinding(layoutInflater: LayoutInflater, container: ViewGroup?): VIEW_DATA_BINDING {
        return DataBindingUtil.inflate(layoutInflater, layout, container, false)
    }
}