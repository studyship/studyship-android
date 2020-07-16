package com.tsdev.presentation.di

import com.tsdev.presentation.HomeFragmentViewModel
import com.tsdev.presentation.SearchKeywordViewModel
import com.tsdev.presentation.ext.CustomFinishProviderImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (customClickEvent: CustomFinishProviderImpl) ->SearchKeywordViewModel(customClickEvent) }

    viewModel { HomeFragmentViewModel() }
}