package com.studyship.application.ui.widget

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.studyship.application.R
import com.studyship.application.databinding.LayoutBottomSheetBinding
import com.studyship.application.ui.adapter.BottomSheetRecyclerAdapter
import com.studyship.application.ui.viewmodel.SearchActivityViewModel

class CustomBottomSheetDialog(
    private val viewModel: SearchActivityViewModel,
    private val supportFragmentManager: FragmentManager,
    private val bottomSheetRecyclerAdapter: BottomSheetRecyclerAdapter
) : BottomSheetDialogFragment() {

    lateinit var binding: LayoutBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<LayoutBottomSheetBinding>(
            inflater,
            R.layout.layout_bottom_sheet,
            container,
            false
        ).also {
            it.vm = viewModel
            it.lifecycleOwner = this.viewLifecycleOwner
            it.executePendingBindings()
        }
        return binding.root
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    fun showDialogWithData(names: List<String>) {
        show(supportFragmentManager, this.tag)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomSheetRecyclerview.adapter = bottomSheetRecyclerAdapter
    }
}