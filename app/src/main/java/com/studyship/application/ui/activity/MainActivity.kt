package com.studyship.application.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.skydoves.transformationlayout.onTransformationStartContainer
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.databinding.ActivityMainBinding
import com.studyship.application.ext.showToast
import com.studyship.application.util.BackKeyPressUtil
import com.studyship.application.util.loadNavigation
import com.tsdev.presentation.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity :
    BaseActivity<MainActivityViewModel, ActivityMainBinding>(R.layout.activity_main) {

    override val viewModel: MainActivityViewModel by viewModel()

    private var navHostFragment: NavHostFragment? = null

    private val backKeyPressUtil by inject<BackKeyPressUtil> {
        parametersOf(
            compositeDisposable,
            ::finish,
            ::showToast,
            ::showToast
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)

        setUpNavHostFragment()
    }

    private fun setUpNavHostFragment() {
        navHostFragment = loadNavigation(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }
    }

    override fun onBackPressed() {
        backKeyPressUtil.onPressedBackKey()
    }
}