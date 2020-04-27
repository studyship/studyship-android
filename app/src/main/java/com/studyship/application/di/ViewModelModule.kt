package com.studyship.application.di

import com.studyship.application.data.local.SharedPreferenceData
import com.studyship.application.data.local.SharedPreferenceDataImpl
import com.studyship.application.ui.viewmodel.HomeFragmentViewModel
import com.studyship.application.ui.viewmodel.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single<SharedPreferenceData> { SharedPreferenceDataImpl(androidContext()) }

    viewModel { HomeFragmentViewModel() }

    viewModel { MainActivityViewModel(get()) }
}