package tsthec.tsstudy.domain.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.domain.Repository

interface StudyShipRepository : Repository {
    fun getLoadUserSearchHistory(): Maybe<List<String>>

    fun setUserSearchHistory(keywords: String): Completable
}