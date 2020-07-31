package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel

class MyStudyViewModel : BaseViewModel() {
    private val _joinLiveDataList = MutableLiveData<List<*>>()

    val joinLiveDataList: LiveData<List<*>>
        get() = _joinLiveDataList

}