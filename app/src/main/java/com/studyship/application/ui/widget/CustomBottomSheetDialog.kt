package com.studyship.application.ui.widget

import android.app.Dialog
import com.studyship.application.BR
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.studyship.application.R
import com.studyship.application.databinding.LayoutBottomSheetBinding
import com.studyship.application.databinding.LayoutMakeStudyBottomSheetBinding
import com.tsdev.presentation.HomeFragmentViewModel
import com.tsdev.presentation.SearchKeywordViewModel
import com.tsdev.presentation.base.BaseViewModel

class CustomBottomSheetDialog(
    @LayoutRes private val bottomSheetLayout: Int,
    private var viewModel: BaseViewModel,
    private val supportFragmentManager: FragmentManager,
    private val bottomSheetRecyclerAdapter: RecyclerView.Adapter<*>,
    private val customTheme: Int
) : BottomSheetDialogFragment() {

    lateinit var binding: ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            bottomSheetLayout,
            container,
            false
        )

        setDataBinding()

        return binding.root
    }

    override fun getTheme(): Int = customTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(requireContext(), theme)

    fun showDialogWithData() {
        //중복 추가 방지.
        if (!isAdded) {
            show(supportFragmentManager, this.tag)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBottomSheetRecyclerAdapter()
    }


    private fun setBottomSheetRecyclerAdapter() {
        when (bottomSheetLayout) {
            R.layout.layout_bottom_sheet -> {
                (binding as LayoutBottomSheetBinding).bottomSheetRecyclerview.adapter =
                    bottomSheetRecyclerAdapter
            }
            R.layout.layout_make_study_bottom_sheet -> {
                (binding as LayoutMakeStudyBottomSheetBinding).makeStudyRecyclerView.adapter =
                    bottomSheetRecyclerAdapter
            }
        }
    }

    private fun setDataBinding() {
        when (bottomSheetLayout) {
            R.layout.layout_bottom_sheet -> {
                binding.setVariable(BR.viewModel, viewModel as SearchKeywordViewModel)
                binding.lifecycleOwner = this.viewLifecycleOwner
                binding.executePendingBindings()
            }
            R.layout.layout_make_study_bottom_sheet -> {
                binding.setVariable(BR.homeViewModel, viewModel as HomeFragmentViewModel)
                binding.lifecycleOwner = this.viewLifecycleOwner
                binding.executePendingBindings()
            }
        }
    }
}