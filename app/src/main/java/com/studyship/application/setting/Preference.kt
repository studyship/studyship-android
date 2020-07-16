package com.studyship.application.setting

import android.content.SharedPreferences
import androidx.core.content.edit

private const val SEARCH_HISTORY = "history_list"
private const val SPLIT_CHAR = "|"

class StringSharedPreference(
    private val preference: SharedPreferences
) {

    fun saveSearchHistory(historyList: List<String>) {
        val searchHistoryList = mutableListOf<String>()
        if (historyList.isNotEmpty()) {
            searchHistoryList.addAll(historyList)
        }
        var preferenceString = ""

        searchHistoryList.forEach {
            preferenceString += it
            preferenceString += SPLIT_CHAR
        }

        preference.edit { putString(SEARCH_HISTORY, preferenceString) }
    }
}