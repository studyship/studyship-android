package tsthec.tsstudy.local.db.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.local.db.entity.UserSearchLocalHistory

@Dao
interface UserSearchHistoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUserLastSearchHistory(keywords: UserSearchLocalHistory): Completable

    @Query("Select * from userSearchLocalHistory")
    fun loadUserSearchHistory(): Maybe<List<UserSearchLocalHistory>>

    @Query("Delete from userSearchLocalHistory Where keywords = :item")
    fun deleteUserSearchHistory(item: UserSearchLocalHistory): Completable
}