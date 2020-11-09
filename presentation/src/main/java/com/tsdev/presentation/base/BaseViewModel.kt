package com.tsdev.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    internal val disposable by lazy { CompositeDisposable() }
}