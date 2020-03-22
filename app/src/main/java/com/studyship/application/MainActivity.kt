package com.studyship.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.studyship.application.ui.activity.AddStudyActivity
import com.studyship.application.util.loadNavigation
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        navHostFragment = loadNavigation(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }
        fab.setOnClickListener {
            startActivity<AddStudyActivity>()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}