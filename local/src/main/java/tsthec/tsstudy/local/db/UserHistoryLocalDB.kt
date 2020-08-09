package tsthec.tsstudy.local.db

import android.content.Context
import androidx.room.*
import tsthec.tsstudy.local.db.convert.DomainSearchUserConverter
import tsthec.tsstudy.local.db.dao.UserSearchHistoryDAO
import tsthec.tsstudy.local.db.entity.UserSearchLocalHistory

@Database(entities = [UserSearchLocalHistory::class], version = 1, exportSchema = false)
@TypeConverters(value = [DomainSearchUserConverter::class])
internal abstract class UserHistoryLocalDB : RoomDatabase() {
    abstract fun userSearchHistoryDAO(): UserSearchHistoryDAO

    companion object {
        private const val DB_NAME = "search_history_db"

        private var instance: UserHistoryLocalDB? = null
        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext, UserHistoryLocalDB::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
            }
    }
}