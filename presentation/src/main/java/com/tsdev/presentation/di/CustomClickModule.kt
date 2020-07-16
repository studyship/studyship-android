package com.tsdev.presentation.di

import android.view.View
import com.tsdev.presentation.ext.CustomFinishProviderImpl
import org.koin.dsl.module

val customClickModule = module {
    factory<View.OnClickListener> { (finish: () -> Unit) -> CustomFinishProviderImpl(finish) }
}