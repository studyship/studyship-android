package tsthec.tsstudy.domain.usecase

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.domain.repository.StudyShipRepository
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase

class GetStudyShipSharedPreferenceUseCase(
    private val studyShipRepository: StudyShipRepository,
    subscribeOnScheduler: Scheduler = Schedulers.io()
) : CompletableUseCase<DomainSearchUserHistory, DomainSearchUserHistory>(subscribeOnScheduler) {
    override fun buildMaybeUseCase(params: DomainSearchUserHistory): Maybe<List<DomainSearchUserHistory>> {
        return if (params.userKeywords.isEmpty()) {
            studyShipRepository.getLoadUserSearchHistory()
        } else {
            studyShipRepository.setUserSearchHistory(params).toMaybe()
        }
    }

    override fun removeUserSearchHistory(item: DomainSearchUserHistory): Completable {
        return studyShipRepository.removeUserSearchHistory(item)
    }

    override fun deleteAllHistory(): Completable {
        return studyShipRepository.deleteAllHistory()
    }

    override fun insertUserAllHistory(history: List<DomainSearchUserHistory>): Completable {
        return studyShipRepository.insertUserSearchHistory(history)
    }
}