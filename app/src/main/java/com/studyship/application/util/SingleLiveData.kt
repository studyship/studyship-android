package com.studyship.application.util


import androidx.lifecycle.Observer

class Event<out T : Any>(private val content: T) {
    var pendingData = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (pendingData)
            null
        else {
            pendingData = true
            content
        }
    }

    fun getContentValue(): T = content
}

class SingleLiveData<ITEM : Any>(private val onChangeListener: (ITEM) -> Unit) :
    Observer<Event<ITEM>> {


    override fun onChanged(event: Event<ITEM>?) {
        event?.getContentIfNotHandled()?.let {
            onChangeListener(it)
        }
    }
}
