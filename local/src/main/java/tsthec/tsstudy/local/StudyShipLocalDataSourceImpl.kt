package tsthec.tsstudy.local

import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.local.settings.UserSearchHistoryPreference

internal class StudyShipLocalDataSourceImpl(private val preferences: UserSearchHistoryPreference) :
    StudyShipLocalRemoteDataSource {
    override fun loadUserSearchHistory(): Maybe<List<String>> {
        return preferences.loadSearchHistory()
    }

    override fun saveUserSearchHistory(keywords: String): Completable {
        return preferences.saveSearchHistory(keywords)
    }
}