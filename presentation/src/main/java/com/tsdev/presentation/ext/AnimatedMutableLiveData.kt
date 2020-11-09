package com.tsdev.presentation.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class AnimatedMutableLiveData<T> {
    private val _liveDataList = mutableListOf<MutableLiveData<T>>()
    private val liveDataList: List<LiveData<T>>
        get() = _liveDataList

    fun setterAnimatedInitData(vararg params: MutableLiveData<T>) {
        params.forEach {
            _liveDataList.add(it)
        }
    }

    fun onChangeValue(position: Int, onChange: (MutableLiveData<T>) -> Unit) {
        _liveDataList.forEachIndexed { index, mutableLiveData ->
            if (index == position) {
                onChange(mutableLiveData)
            }
        }
    }

    fun getValue(position: Int): LiveData<T>? {
        return liveDataList[position]
    }

    companion object {
        private const val EMAIL = 0
        private const val PASSWORD = 1
        private const val PASSWORD_CHECK = 2
    }
}