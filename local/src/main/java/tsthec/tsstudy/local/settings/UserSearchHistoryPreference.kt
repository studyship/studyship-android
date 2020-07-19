package tsthec.tsstudy.local.settings

import android.content.SharedPreferences
import androidx.core.content.edit
import io.reactivex.Completable
import io.reactivex.Maybe

const val SEARCH_HISTORY = "history_list"
private const val SPLIT_CHAR = "|"
private const val DEFAULT_VALUE = ""
private val searchHistoryList = mutableListOf<String>()

class UserSearchHistoryPreference(
    private val preference: SharedPreferences
) {

    fun saveSearchHistory(historyKeyword: String): Completable {
        return if (historyKeyword.isNotEmpty()) {
            searchHistoryList.add(historyKeyword)

            var preferenceString = ""

            searchHistoryList.forEach {
                preferenceString += it
                preferenceString += SPLIT_CHAR
            }

            preference.edit { putString(SEARCH_HISTORY, preferenceString) }

            Completable.complete()
        } else {
            Completable.error(Throwable("empty History-keywords"))
        }
    }


    fun loadSearchHistory(): Maybe<List<String>> {
        val historyList = preference.getString(SEARCH_HISTORY, DEFAULT_VALUE)
        return Maybe.just(historyList?.split(SPLIT_CHAR)?.filter {
            it.isNotEmpty()
        } ?: emptyList())
    }

    fun removeSearchHistory(position: Int) {
        val userHistoryList =
            preference.getString(SEARCH_HISTORY, DEFAULT_VALUE)?.split(SPLIT_CHAR) ?: emptyList()
        searchHistoryList.addAll(userHistoryList)
//        preference.edit { clear() }
//        var preferenceString = ""

        searchHistoryList.removeAt(position)
//        searchHistoryList.forEach {
//            preferenceString += it
//            preferenceString += SPLIT_CHAR
//        }
//        preference.edit { putString(SEARCH_HISTORY, preferenceString) }
    }
}