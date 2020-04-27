package com.studyship.application.di

import com.studyship.application.ui.viewmodel.HomeFragmentViewModel
import com.studyship.application.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel() }

    viewModel { MainActivityViewModel() }
}