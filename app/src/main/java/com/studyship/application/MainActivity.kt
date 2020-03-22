package com.studyship.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.studyship.application.util.loadFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        navHostFragment = loadFragment(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }
    }
}