package com.studyship.application.ui.widget

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.studyship.application.R
import com.studyship.application.ui.viewmodel.SearchActivityViewModel

class CustomBottomSheetDialog(viewModel: SearchActivityViewModel) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_bottom_sheet, container, false)
    }

    fun showDialog() {
//        show(, this.tag)
        Log.i("TAG", "Click!!")
    }
}