package com.tsdev.presentation

import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.Event
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent

class SplashViewModel : BaseViewModel() {
    private val _splashCallback = SingleMutableEvent<Boolean>()

    val splashCallback: SingleEvent<Boolean>
        get() = _splashCallback


    val postDelayStartActivity: () -> Unit = {
        _splashCallback.value = Event(true)
    }
}