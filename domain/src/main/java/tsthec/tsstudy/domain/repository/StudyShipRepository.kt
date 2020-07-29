package tsthec.tsstudy.domain.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import tsthec.tsstudy.domain.Repository
import tsthec.tsstudy.domain.model.DomainSearchUserHistory

interface StudyShipRepository : Repository {
    fun getLoadUserSearchHistory(): Maybe<List<DomainSearchUserHistory>>

    fun setUserSearchHistory(keywords: DomainSearchUserHistory): Completable

    fun removeUserSearchHistory(position: DomainSearchUserHistory): Completable

    fun insertUserSearchHistory(keywords: List<DomainSearchUserHistory>): Completable

    fun deleteAllHistory(): Completable
}