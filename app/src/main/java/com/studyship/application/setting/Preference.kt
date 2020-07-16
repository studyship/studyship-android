package com.studyship.application.setting

import android.content.SharedPreferences
import androidx.core.content.edit

const val SEARCH_HISTORY = "history_list"
private const val SPLIT_CHAR = "|"

private val searchHistoryList = mutableListOf<String>()

class StringSharedPreference(
    private val preference: SharedPreferences
) {

    fun saveSearchHistory(historyList: String) {
        if (historyList.isNotEmpty()) {
            searchHistoryList.add(historyList)
        }
        var preferenceString = ""

        searchHistoryList.forEach {
            preferenceString += it
            preferenceString += SPLIT_CHAR
        }

        preference.edit(commit = true) { putString(SEARCH_HISTORY, preferenceString) }
    }

    fun loadSearchHistory(): List<String> {
        val searchHistoryList = mutableListOf<String>()
        val historyList = preference.getString(SEARCH_HISTORY, "")
        searchHistoryList.addAll(historyList?.split(SPLIT_CHAR) ?: emptyList())
        return searchHistoryList
    }
}