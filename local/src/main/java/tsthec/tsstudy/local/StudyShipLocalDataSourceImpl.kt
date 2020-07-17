package tsthec.tsstudy.local

import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

internal class StudyShipLocalDataSourceImpl(private val preferences: UserSearchHistoryPreference) :
    StudyShipLocalRemoteDataSource {
    override fun loadUserSearchHistory(): List<String> {
        return preferences.loadSearchHistory()
    }

    override fun saveUserSearchHistory(keywords: String) {
        preferences.saveSearchHistory(keywords)
    }
}