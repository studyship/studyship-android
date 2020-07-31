package com.studyship.application.di

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.studyship.application.util.BackKeyPressUtil
import com.studyship.application.util.BackKeyPressUtilImpl
import com.tsdev.presentation.SearchKeywordViewModel
import io.reactivex.disposables.CompositeDisposable
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

    factory <BackKeyPressUtil> { (disposable: CompositeDisposable, finish: () -> Unit, toast: (Int, Int) -> Unit, errorToast: (Int, Int) -> Unit) ->
        BackKeyPressUtilImpl(
            disposable,
            finish,
            toast,
            errorToast
        )
    }
}