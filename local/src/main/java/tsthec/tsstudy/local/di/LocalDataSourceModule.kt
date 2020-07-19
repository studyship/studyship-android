package tsthec.tsstudy.local.di

import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import tsthec.tsstudy.local.StudyShipLocalDataSourceImpl
import tsthec.tsstudy.local.db.UserHistoryLocalDB

private const val DB_NAME = "latest_history_db"

val localDataSourceModule = module {
    single {UserHistoryLocalDB.getInstance(androidApplication())}

    single { get<UserHistoryLocalDB>().userSearchHistoryDAO() }

    single<StudyShipLocalRemoteDataSource> { StudyShipLocalDataSourceImpl(get()) }
}