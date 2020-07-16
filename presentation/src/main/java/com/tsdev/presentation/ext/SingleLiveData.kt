package com.tsdev.presentation.ext

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


typealias MutableSingleEvent<T> = MutableLiveData<Event<T>>
typealias SingleEvent<T> = LiveData<Event<T>>

class Event<out VALUE>(private val content: VALUE) {
    private var pendingData = false

    fun getContentIfNotHandled(): VALUE? {
        return if (pendingData)
            null
        else {
            pendingData = true
            content
        }
    }

    fun getContentValue(): VALUE = content
}

class SingleLiveData<ITEM>(private val onChangeListener: (ITEM) -> Unit) :
    Observer<Event<ITEM>> {
    override fun onChanged(event: Event<ITEM>?) {
        event?.getContentIfNotHandled()?.let {
            onChangeListener(it)
        }
    }
}

inline fun <T> SingleEvent<T>.singleObserve(
    lifecycleOwner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    observe(lifecycleOwner, SingleLiveData { observer(it) })
}

class SingleMutableEvent<VALUE> : MutableSingleEvent<VALUE>() {
    var event: VALUE?
        set(value) {
            if (value != null) {
                setValue(Event(value))
            }
        }
        get() = value?.getContentValue()

    fun postEvent(value: VALUE) {
        if(value != null)
            postValue(Event(value))
    }
}