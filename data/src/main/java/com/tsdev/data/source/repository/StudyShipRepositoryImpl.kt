package com.tsdev.data.source.repository

import com.tsdev.data.source.local.StudyShipLocalRemoteDataSource
import com.tsdev.data.source.remote.StudyShipRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.domain.repository.StudyShipRepository

internal class StudyShipRepositoryImpl(
    private val studyShipLocalRemoteDataSource: StudyShipLocalRemoteDataSource
) : StudyShipRepository {
    override fun getLoadUserSearchHistory(): Maybe<List<String>> {
        return studyShipLocalRemoteDataSource.loadUserSearchHistory()
    }

    override fun setUserSearchHistory(keywords: String): Completable {
        return studyShipLocalRemoteDataSource.saveUserSearchHistory(keywords)
    }
}