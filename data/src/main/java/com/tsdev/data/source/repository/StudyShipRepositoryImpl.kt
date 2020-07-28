package com.tsdev.data.source.repository

import com.tsdev.data.mapper.DomainMapper
import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.domain.repository.StudyShipRepository

internal class StudyShipRepositoryImpl(
    private val studyShipLocalRemoteDataSource: StudyShipLocalRemoteDataSource,
    private val databaseScheduler: Scheduler = Schedulers.computation()
) : StudyShipRepository {
    override fun getLoadUserSearchHistory(): Maybe<List<DomainSearchUserHistory>> {
        return studyShipLocalRemoteDataSource.loadUserSearchHistory()
            .map {
                it.map(DomainMapper::mapperToDomain)
            }
    }

    override fun setUserSearchHistory(keywords: DomainSearchUserHistory): Completable {
        return studyShipLocalRemoteDataSource.saveUserSearchHistory(
            DomainMapper.mapperToData(
                keywords
            )
        )
    }

    override fun removeUserSearchHistory(position: DomainSearchUserHistory): Completable {
        return studyShipLocalRemoteDataSource.removeUserSearchHistory(
            DomainMapper.mapperToData(
                position
            )
        )
            .subscribeOn(databaseScheduler)
    }
}