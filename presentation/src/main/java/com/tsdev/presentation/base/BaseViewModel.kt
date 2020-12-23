package com.tsdev.presentation.base

import androidx.lifecycle.ViewModel
import com.tsdev.presentation.ext.SingleMutableEvent
import io.reactivex.disposables.CompositeDisposable
import navigation.NavigationAction

abstract class BaseViewModel : ViewModel() {
    val navigationAction = SingleMutableEvent<NavigationAction>()
    internal val disposable by lazy { CompositeDisposable() }
}