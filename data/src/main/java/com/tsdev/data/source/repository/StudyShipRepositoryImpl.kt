package com.tsdev.data.source.repository

import com.tsdev.data.mapper.DomainMapper
import com.tsdev.data.source.UserSearchHistory
import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import com.tsdev.data.source.remote.StudyShipRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.domain.repository.StudyShipRepository

internal class StudyShipRepositoryImpl(
    private val studyShipLocalRemoteDataSource: StudyShipLocalRemoteDataSource
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

    override fun removeUserSearchHistory(position: DomainSearchUserHistory) {
        studyShipLocalRemoteDataSource.removeUserSearchHistory(DomainMapper.mapperToData(position))
    }
}