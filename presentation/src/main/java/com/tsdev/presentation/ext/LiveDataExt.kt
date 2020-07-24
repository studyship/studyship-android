package com.tsdev.presentation.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun <T> MediatorLiveData<T>.setObservable(vararg liveItems: LiveData<*>, onChanged: () -> T) {
    liveItems.forEach {
        addSource(it) {
            value = onChanged()
        }
    }
}