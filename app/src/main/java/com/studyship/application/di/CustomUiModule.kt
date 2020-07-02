package com.studyship.application.di

import com.studyship.application.ui.viewmodel.SearchActivityViewModel
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import org.koin.dsl.module

val customUiModule = module {
    factory { (viewModel: SearchActivityViewModel) -> CustomBottomSheetDialog(viewModel) }
}