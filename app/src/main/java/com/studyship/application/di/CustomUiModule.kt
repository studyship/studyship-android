package com.studyship.application.di

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.tsdev.presentation.SearchKeywordViewModel
import org.koin.dsl.module

val customUiModule = module {
    factory { (bottomSheetDialog: Int, viewModel: ViewModel, supportFragmentManager: FragmentManager,
                  bottomSheetRecyclerAdapter: RecyclerView.Adapter<*>, theme: Int) ->
        CustomBottomSheetDialog(
            bottomSheetDialog,
            viewModel,
            supportFragmentManager,
            bottomSheetRecyclerAdapter,
            theme
        )
    }
}