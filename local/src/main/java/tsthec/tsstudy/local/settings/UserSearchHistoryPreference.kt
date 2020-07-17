package tsthec.tsstudy.local.settings

import android.content.SharedPreferences
import androidx.core.content.edit

const val SEARCH_HISTORY = "history_list"
private const val SPLIT_CHAR = "|"

private val searchHistoryList = mutableListOf<String>()

class UserSearchHistoryPreference(
    private val preference: SharedPreferences
) {

    fun saveSearchHistory(historyKeyword: String) {
        if (historyKeyword.isNotEmpty()) {
            searchHistoryList.add(historyKeyword)
        }
        var preferenceString = ""

        searchHistoryList.forEach {
            preferenceString += it
            preferenceString += SPLIT_CHAR
        }

        preference.edit(commit = true) { putString(SEARCH_HISTORY, preferenceString) }
    }

    fun loadSearchHistory(): List<String> {
        val historyList = preference.getString(SEARCH_HISTORY, "")
        return historyList?.split(SPLIT_CHAR)?.filter {
            it.isNotEmpty()
        } ?: emptyList()
    }
}