package com.studyship.application.data.local

import android.content.Context

interface SharedPreferenceData {
    val context: Context

    fun getSpotLightSharedPreferData(): Boolean

    fun saveSpotLightSharedPreferData()

//    fun saveSearchHistory(keyword: String)
//
//    fun loadSearchHistory(): List<String>
}