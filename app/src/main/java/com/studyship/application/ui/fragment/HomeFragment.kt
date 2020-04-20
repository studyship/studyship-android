package com.studyship.application.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.transformationlayout.TransformationLayout
import com.studyship.application.R
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentHomeLayoutBinding
import com.studyship.application.ui.activity.StudyApplyActivity
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter
import com.studyship.application.ui.adapter.holder.delegate.IRecyclerDelegate
import com.studyship.application.ui.viewmodel.HomeFragmentViewModel
import com.studyship.application.util.comfortableStartActivity
import kotlinx.android.synthetic.main.fragment_home_layout.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeLayoutBinding>(R.layout.fragment_home_layout),
    IRecyclerDelegate {

    override lateinit var viewDataBinding: FragmentHomeLayoutBinding

    private val homeViewModel by viewModel<HomeFragmentViewModel>()

    private val homeCategoryRecyclerAdapter: CategoryRecyclerAdapter by lazy {
        CategoryRecyclerAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = onCreateViewBinding(inflater, container)

        viewDataBinding.homeFragmentViewModel = homeViewModel
        viewDataBinding.run {
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }

        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewDataBinding.root.category_recycler_view.run {
            layoutManager = GridLayoutManager(this.context, 3)
            adapter = homeCategoryRecyclerAdapter
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClickItem(position: Int, translateLayout: TransformationLayout) {
        context?.comfortableStartActivity<StudyApplyActivity>(
            "key" to homeCategoryRecyclerAdapter.itemCount, transformationLayout = translateLayout
        )
    }
}