package tsthec.tsstudy.local

import android.util.Log
import com.tsdev.data.source.UserSearchHistory
import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.local.db.dao.UserSearchHistoryDAO
import tsthec.tsstudy.local.mapper.UserSearchLocalMapper

internal class StudyShipLocalDataSourceImpl(private val searchHistoryDAO: UserSearchHistoryDAO) :
    StudyShipLocalRemoteDataSource {
    override fun loadUserSearchHistory(): Maybe<List<UserSearchHistory>> {
        return searchHistoryDAO.loadUserSearchHistory().map {
            it.map(UserSearchLocalMapper::mapToLocal)
        }
    }

    override fun saveUserSearchHistory(keywords: UserSearchHistory): Completable {
        Log.e("save", UserSearchLocalMapper.mapToEntity(keywords).hashCode().toString())
        return searchHistoryDAO.saveUserLastSearchHistory(UserSearchLocalMapper.mapToEntity(keywords))
    }

    override fun removeUserSearchHistory(position: UserSearchHistory): Completable {
        Log.e("delete", position.toString())
        return searchHistoryDAO.deleteUserSearchHistory(UserSearchLocalMapper.mapToEntity(position).searchKeyword)
    }
}