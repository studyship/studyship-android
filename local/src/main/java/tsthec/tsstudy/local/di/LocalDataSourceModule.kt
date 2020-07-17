package tsthec.tsstudy.local.di

import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import org.koin.dsl.module
import tsthec.tsstudy.local.StudyShipLocalDataSourceImpl

val localDataSourceModule = module {
    factory<StudyShipLocalRemoteDataSource> { StudyShipLocalDataSourceImpl(get()) }
}