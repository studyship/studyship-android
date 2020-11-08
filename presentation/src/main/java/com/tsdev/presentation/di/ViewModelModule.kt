package com.tsdev.presentation.di

import com.tsdev.presentation.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchKeywordViewModel(get()) }

    viewModel { HomeFragmentViewModel() }

    viewModel { MainActivityViewModel() }

    viewModel { MakeStudyViewModel() }

    viewModel { MyStudyViewModel() }

    viewModel { SplashViewModel() }

    viewModel { StudyCategoryViewModel() }

    viewModel { CategoryMainViewModel() }
}