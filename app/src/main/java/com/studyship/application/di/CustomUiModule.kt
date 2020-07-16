package com.studyship.application.di

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.viewmodel.SearchActivityViewModel
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import org.koin.dsl.module

val customUiModule = module {
    factory { (viewModel: SearchActivityViewModel, supportFragmentManager: FragmentManager,
                  bottomSheetRecyclerAdapter: BottomSheetRecyclerAdapter) ->
        CustomBottomSheetDialog(
            viewModel,
            supportFragmentManager,
            bottomSheetRecyclerAdapter
        )
    }
}