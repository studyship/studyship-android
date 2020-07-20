package com.studyship.application.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.skydoves.transformationlayout.onTransformationStartContainer
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.ui.adapter.MakeStudyRecyclerAdapter
import com.studyship.application.ui.widget.CustomBottomSheetDialog
import com.studyship.application.util.loadNavigation
import com.studyship.application.util.plusAssign
import com.tsdev.presentation.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : BaseActivity<MainActivityViewModel>() {

    private val makeStudyRecyclerAdapter: MakeStudyRecyclerAdapter by lazy {
        MakeStudyRecyclerAdapter()
    }

    private val bottomSheet by inject<CustomBottomSheetDialog> {
        parametersOf(
            R.layout.layout_make_study_bottom_sheet,
            viewModel,
            supportFragmentManager,
            makeStudyRecyclerAdapter,
            R.style.iOSBottomSheetDialogTheme
        )
    }

    override val viewModel: MainActivityViewModel by viewModel()

    private var navHostFragment: NavHostFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        compositeDisposable +=
            backButtonBehaviorSubject.buffer(2, 1).map {
                it[0] to it[1]
            }.subscribe {
                if (it.second - it.first < BACK_BUTTON_ITEM)
                    finish()
                else
                    Toast.makeText(
                            this,
                            getString(R.string.back_button_click_message),
                            Toast.LENGTH_LONG
                        )
                        .show()
            }

        navHostFragment = loadNavigation(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }

        create_study.setOnClickListener { bottomSheet.showDialogWithData() }
    }

    override fun onBackPressed() {
        backButtonBehaviorSubject.onNext(System.currentTimeMillis())
    }

    companion object {
        private const val BACK_BUTTON_ITEM = 2000L
    }
}