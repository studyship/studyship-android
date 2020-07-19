package com.studyship.application.data.local

import android.content.Context
import androidx.core.content.edit

private const val SHARED_PREFERENCE_MODE = 0
private const val SHARED_PREFERENCE_KEY = "spotlight-show"

class SharedPreferenceDataImpl(contextData: Context) : SharedPreferenceData {
    override val context: Context = contextData

    override fun getSpotLightSharedPreferData(): Boolean {
        return context.getSharedPreferences(this.javaClass.simpleName, SHARED_PREFERENCE_MODE)
            .getBoolean(SHARED_PREFERENCE_KEY, false)
    }

    override fun saveSpotLightSharedPreferData() {
        context.getSharedPreferences(this.javaClass.simpleName, SHARED_PREFERENCE_MODE).edit {
            putBoolean(SHARED_PREFERENCE_KEY, true)
        }
    }
}