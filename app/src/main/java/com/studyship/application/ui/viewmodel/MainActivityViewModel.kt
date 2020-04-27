package com.studyship.application.ui.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.studyship.application.data.local.SharedPreferenceData
import com.studyship.application.ui.widget.spotlightBuilder
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.Target

class MainActivityViewModel(
    private val sharedPreferenceData: SharedPreferenceData
) : ViewModel() {
    lateinit var spotlight: Spotlight

    fun startTargetView(activity: Activity, target: List<Target>) {
        if (sharedPreferenceData.getSpotLightSharedPreferData())
            return
        spotlight = spotlightBuilder(activity, target).build()
        spotlight.start()
    }

    fun endSpotlightSaveSharedData() {
        spotlight.finish()
        sharedPreferenceData.saveSpotLightSharedPreferData()
    }
}