package com.studyship.application.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class SingleLiveData<ITEM: Any> : LiveData<ITEM>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<in ITEM>) {
        super.observe(owner, observer)
    }
}
