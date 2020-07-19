package com.studyship.application.di

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.tsdev.presentation.SearchKeywordViewModel
import org.koin.dsl.module

val customUiModule = module {
    factory { (viewModel: SearchKeywordViewModel, supportFragmentManager: FragmentManager,
                  bottomSheetRecyclerAdapter: BottomSheetRecyclerAdapter, theme: Int) ->
        CustomBottomSheetDialog(
            viewModel,
            supportFragmentManager,
            bottomSheetRecyclerAdapter,
            theme
        )
    }
}