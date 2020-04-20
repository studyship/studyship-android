package com.studyship.application.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.skydoves.transformationlayout.onTransformationStartContainer
import com.studyship.application.R
import com.studyship.application.base.activity.BaseActivity
import com.studyship.application.util.loadNavigation
import com.studyship.application.util.plusAssign
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : BaseActivity() {
    companion object {
        private const val BACK_BUTTON_ITEM = 2000L
    }

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
        onTransformationStartContainer()
        super.onCreate(savedInstanceState)

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

        setContentView(R.layout.activity_main)
        navHostFragment = loadNavigation(R.id.nav_host_fragment)
        navHostFragment?.let {
            NavigationUI.setupWithNavController(bottom_sheet_menu, it.navController)
        }
    }

    override fun onBackPressed() {
        backButtonBehaviorSubject.onNext(System.currentTimeMillis())
    }
}