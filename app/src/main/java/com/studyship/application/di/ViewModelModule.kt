package com.studyship.application.di

import com.studyship.application.ui.viewmodel.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { HomeFragmentViewModel() }
}