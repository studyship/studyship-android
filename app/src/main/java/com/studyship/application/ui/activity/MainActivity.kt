package com.studyship.application.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.studyship.application.R
import com.studyship.application.util.loadNavigation
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    init {

        solution(8, 12)
    }

    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        val wDouble = w.toDouble().pow(2.0)
        val hDouble = h.toDouble().pow(2.0)
        Log.d("ANSWER wDouble", wDouble.toString())
        Log.d("ANSWER hDouble", hDouble.toString())
        val radio = sqrt((wDouble + hDouble))
        Log.d("ANSWER radio", radio.toString())
        answer = radio.toLong()
        Log.d("ANSWER", answer.toString())
        return answer
    }

    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        navHostFragment = loadNavigation(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}