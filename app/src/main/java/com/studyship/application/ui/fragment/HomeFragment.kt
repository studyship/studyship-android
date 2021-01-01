package com.studyship.application.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.skydoves.transformationlayout.TransformationLayout
import com.studyship.application.R
import com.studyship.application.BR
import com.studyship.application.base.fragment.BaseFragment
import com.studyship.application.databinding.FragmentHomeLayoutBinding
import com.studyship.application.ui.activity.SignUpActivity
import com.studyship.application.ui.activity.SearchActivity
import com.studyship.application.ui.activity.SignInActivity
import com.studyship.application.ui.activity.StudyApplyActivity
import com.studyship.application.ui.adapter.CategoryRecyclerAdapter
import com.studyship.application.ui.adapter.MakeStudyRecyclerAdapter
import com.studyship.application.ui.adapter.holder.delegate.IRecyclerDelegate
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.studyship.application.util.comfortableStartActivity
import com.tsdev.presentation.HomeFragmentViewModel
import com.tsdev.presentation.ext.singleObserve
import kotlinx.android.synthetic.main.appbar_header_layout.view.*
import kotlinx.android.synthetic.main.fragment_home_layout.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import tsthec.tsstudy.library.dialog.AnimatedDialog
import tsthec.tsstudy.library.property.DialogSize
import tsthec.tsstudy.library.property.Duration

class HomeFragment :
    BaseFragment<FragmentHomeLayoutBinding, HomeFragmentViewModel>(R.layout.fragment_home_layout),
    IRecyclerDelegate {
    override val viewModel by viewModel<HomeFragmentViewModel>()

    private val bottomSheet by inject<CustomBottomSheetDialog> {
        parametersOf(
            R.layout.layout_make_study_bottom_sheet,
            viewModel,
            parentFragmentManager,
            makeStudyRecyclerAdapter,
            R.style.iOSBottomSheetDialogTheme
        )
    }

    private val display: AnimatedDialog by lazy {
        Log.e("widthPixels" , resources.displayMetrics.widthPixels.toFloat().toString())
        AnimatedDialog.Builder(requireContext(), R.style.AnimatedDialogStyle)
            .setTitle(getString(R.string.login_alert_title))
            .setPositiveBackground(R.drawable.bg_positive_button)
            .setNegativeBackground(R.drawable.bg_negative_button)
            .setPositiveText(getString(R.string.login))
            .setNegativeText(getString(R.string.cancel))
            .setDialogSize(DialogSize.SMALL)
            .setDuration(Duration.SLOW)
            .build()
    }

    private val makeStudyRecyclerAdapter: MakeStudyRecyclerAdapter by lazy {
        MakeStudyRecyclerAdapter()
    }


    private val homeCategoryRecyclerAdapter: CategoryRecyclerAdapter by lazy {
        CategoryRecyclerAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind {
            homeFragmentViewModel = viewModel
            setVariable(BR.customBottomNavigation, bottomSheet)
        }

        viewDataBinding.root.category_recycler_view.run {
            layoutManager = GridLayoutManager(this.context, 3)
            adapter = homeCategoryRecyclerAdapter
        }

        viewModel.moveSignInActivity.singleObserve(this) {
            if (it) {
                context?.comfortableStartActivity<SignInActivity>()
            }
        }

        viewModel.moveSearchActivity.singleObserve(this) {
            if (it) {
                context?.comfortableStartActivity<SearchActivity>()
            }
        }

        viewDataBinding.root.notification_img.setOnClickListener {
            startActivity(Intent(this.context, SignUpActivity::class.java))
        }
    }

    override fun onClickItem(position: Int, translateLayout: TransformationLayout) {
//        context?.comfortableStartActivity<StudyApplyActivity>(
//            "key" to homeCategoryRecyclerAdapter.itemCount, transformationLayout = translateLayout
//        )
        display.show()
    }
}