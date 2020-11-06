package com.tsdev.presentation.di

import com.tsdev.presentation.helper.ResourceHelper
import com.tsdev.presentation.helper.ResourceHelperIml
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val resourceModule = module {
    single<ResourceHelper> { ResourceHelperIml(androidContext()) }
}