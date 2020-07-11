package com.studyship.application.ui.widget

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.studyship.application.R
import com.studyship.application.databinding.LayoutBottomSheetBinding
import com.studyship.application.ui.viewmodel.SearchActivityViewModel

class CustomBottomSheetDialog(
    private val viewModel: SearchActivityViewModel,
    private val supportFragmentManager: FragmentManager
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<LayoutBottomSheetBinding>(
            inflater,
            R.layout.layout_bottom_sheet,
            container,
            false
        ).also {
            it.vm = viewModel
            it.executePendingBindings()
        }.root
    }


    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    fun showDialogWithData(names: List<String>) {
        show(supportFragmentManager, this.tag)
    }
}