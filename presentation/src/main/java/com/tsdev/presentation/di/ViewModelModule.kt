package com.tsdev.presentation.di

import com.tsdev.presentation.HomeFragmentViewModel
import com.tsdev.presentation.MainActivityViewModel
import com.tsdev.presentation.SearchKeywordViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchKeywordViewModel(get()) }

    viewModel { HomeFragmentViewModel() }

    viewModel { MainActivityViewModel() }
}